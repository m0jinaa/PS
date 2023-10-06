import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Brick {
		int c, p;

		public Brick(int c, int p) {
			super();
			this.c = c;
			this.p = p;
		}
	}

	static int[][] dp;
	static Brick[] bricks;
	static int n;
	static final int X = 20;
	static final int Y = 20000;
	static final int INF = 1_000_000_007;

	static void fill() {
		dp[0][0] = 0;

		int np;
		int nx, ny;
		for (Brick b : bricks) {
			for (int i = X - 1; i >= 0; i--) {
				for (int j = 0; j <= Y; j++) {
					nx = i + 1;
					ny = j + b.c;

					if (dp[i][j] == INF || ny > Y)
						continue;

					np = dp[i][j] + b.p;
					dp[nx][ny] = Math.min(dp[nx][ny], np);

				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		bricks = new Brick[n];

		int c, p;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			c = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());

			bricks[i] = new Brick(c, p);
		}

		dp = new int[X + 1][Y + 1];

		for (int i = 0; i <= X; i++) {
			Arrays.fill(dp[i], INF);
		}

		fill();

		int q = Integer.parseInt(br.readLine());

		int m, l, r;
		int cost;
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());
			l = m * Integer.parseInt(st.nextToken());
			r = m * Integer.parseInt(st.nextToken());

			cost = INF;

			for (int i = l; i <= r; i++) {
				cost = Math.min(cost, dp[m][i]);
			}

			sb.append(cost == INF ? "impossible" : cost).append("\n");
		}

		System.out.print(sb.toString());
	}
}