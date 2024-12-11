import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Menu implements Comparable<Menu> {
		int expensive, cheap;

		public Menu(int expensive, int cheap) {
			super();
			this.expensive = expensive;
			this.cheap = cheap;
		}

		public int compareTo(Menu m) {
			int g1 = this.expensive - this.cheap;
			int g2 = m.expensive - m.cheap;

			return g2 - g1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		Menu[] menus = new Menu[n];

		int a, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			menus[i] = new Menu(a, b);
		}

		Arrays.sort(menus);

		// 천원단위 절사
		int money = x / 1000;

		int answer = 0;

		for (int i = 0; i < n; i++) {

			// 천원짜리 메뉴가 오천원짜리 메뉴와 맛이 같거나 더 맛있는 경우 또는 남아있는 돈으로 학기가 끝날때까지 매일 학식을 먹지 못하는 경우
			if (menus[i].cheap >= menus[i].expensive || n - i - 1 > money - 5) {
				answer += menus[i].cheap;
				money -= 1;
			} else {
				answer += menus[i].expensive;
				money -= 5;
			}
		}

		System.out.println(answer);
	}
}