import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MAX_TIME = 200;
	static int n;
	static boolean[] shouldEat;
	static Food[] foods;

	static class Food implements Comparable<Food> {
		int p, s;

		public Food(int p, int s) {
			super();
			this.p = p;
			this.s = s;
		}

		@Override
		public int compareTo(Food f) {
			return this.p + this.s - (f.p + f.s);
		}
	}

	static int getMaxTime() {
		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = foods[i].p; j >= 0; j--) {
				if (!shouldEat[j])
					continue;
				max = Math.max(max, j + foods[i].s);
				shouldEat[j + foods[i].s] = true;
			}
		}

		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int p, s;
		shouldEat = new boolean[MAX_TIME];

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());

			foods = new Food[n];
			Arrays.fill(shouldEat, false);
			shouldEat[0] = true;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				p = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());

				foods[i] = new Food(p, s);
			}

			Arrays.sort(foods);

			sb.append("Case #").append(t).append(": ").append(getMaxTime()).append("\n");
		}

		System.out.print(sb.toString());
	}
}