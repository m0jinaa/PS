import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_007;
	static int n, p1, p3, p5, pp;
	static char[][] plan;
	static int[][] dp;

	static int getMinCost(int x, int y) {
		if (dp[x][y] != INF)
			return dp[x][y];

		int cost = INF;
		int nx, ny;

		if (x < n) {
			if (plan[0][x] == '0') {
				cost = Math.min(cost, getMinCost(x + 1, y));
			}
			nx = Math.min(n, x + 1);
			cost = Math.min(cost, p1 + getMinCost(nx, y));

			nx = Math.min(n, x + 3);
			cost = Math.min(cost, p3 + getMinCost(nx, y));

			nx = Math.min(n, x + 5);
			cost = Math.min(cost, p5 + getMinCost(nx, y));
		}

		if (y < n) {
			if (plan[1][y] == '0') {
				cost = Math.min(cost, getMinCost(x, y + 1));
			}

			ny = Math.min(n, y + 1);
			cost = Math.min(cost, p1 + getMinCost(x, ny));

			ny = Math.min(n, y + 3);
			cost = Math.min(cost, p3 + getMinCost(x, ny));

			ny = Math.min(n, y + 5);
			cost = Math.min(cost, p5 + getMinCost(x, ny));

		}

		nx = Math.min(n, x + 4);
		ny = Math.min(n, y + 4);

		cost = Math.min(cost, pp + getMinCost(nx, ny));

		return dp[x][y] = cost;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		plan = new char[2][];

		for (int i = 0; i < 2; i++) {
			plan[i] = br.readLine().toCharArray();
		}

		st = new StringTokenizer(br.readLine(), " ");

		p1 = Integer.parseInt(st.nextToken());
		p3 = Integer.parseInt(st.nextToken());
		p5 = Integer.parseInt(st.nextToken());
		pp = Integer.parseInt(st.nextToken());

		dp = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], INF);
		}

		dp[n][n] = 0;

		int answer = getMinCost(0, 0);

		System.out.println(answer);
	}
}