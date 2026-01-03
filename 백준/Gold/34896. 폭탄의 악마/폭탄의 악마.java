import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, b;
	static Bomb[] bombs;

	static class Bomb implements Comparable<Bomb> {
		int x, c;

		public Bomb(int x) {
			super();
			this.x = x;
		}

		public void setC(int c) {
			this.c = c;
		}

		@Override
		public int compareTo(Bomb bomb) {
			return this.x - bomb.x;
		}
	}

	// 모든 폭탄을 터트리기 위한 최소 비용의 합과 의뢰비용 비교 후 리턴
	static boolean checkPossible(int r) {
		int money = 0;

		int min = bombs[0].c;

		for (int i = 1; i < n; i++) {
			if (bombs[i].x - bombs[i - 1].x > r) {
				money += min;
				min = bombs[i].c;
			} else {
				min = Math.min(bombs[i].c, min);
			}
		}

		money += min;

		return money <= b;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		bombs = new Bomb[n];

		int x, c;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());

			bombs[i] = new Bomb(x);
		}

		// 폭탄 위치 정렬

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			c = Integer.parseInt(st.nextToken());
			bombs[i].setC(c);
		}

		Arrays.sort(bombs);

		b = Integer.parseInt(br.readLine());

		int s = 1;
		int e = bombs[n - 1].x - bombs[0].x;

		int mid;

		int answer = e + 1;

		while (s <= e) {
			mid = (s + e) / 2;

			// 의뢰 비용 내에서 모든 폭탄을 터트릴 수 있는지 확인
			if (checkPossible(mid)) {
				e = mid - 1;
				answer = mid;
			} else {
				s = mid + 1;
			}
		}

		System.out.println(answer);
	}
}