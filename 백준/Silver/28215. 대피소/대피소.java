import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class House {
		int x, y;

		public House(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int n, k;
	static House[] houses;
	static int[] shelter;
	static final int INF = 1_000_000_007;
	static int answer = INF;

	// a집과 b집 사이의 맨해탄 거리
	static int getDist(int a, int b) {
		if (a == b)
			return 0;
		else {
			return Math.abs(houses[a].x - houses[b].x) + Math.abs(houses[a].y - houses[b].y);
		}
	}

	static void check() {
		// 가장 가까운 대피소와 집 사이의 최대 거리
		int max = 0;

		// 가장 가까운 대피소와 집 사이의 거리
		int min = INF;

		for (int i = 0; i < n; i++) {
			min = INF;
			for (int j : shelter) {
				min = Math.min(min, getDist(i, j));
			}
			max = Math.max(max, min);
		}

		answer = Math.min(answer, max);
	}

	static void select(int ind, int x) {
		if (ind == k) {
			check();
		} else if (x == n) {
			return;
		} else {
			// i번째집 대피소로 선택
			shelter[ind] = x;
			select(ind + 1, x + 1);

			// i번째집은 대피소로 선택 x
			select(ind, x + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		houses = new House[n];
		shelter = new int[k];

		int x, y;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			houses[i] = new House(x, y);
		}

		select(0, 0);

		System.out.println(answer);
	}
}