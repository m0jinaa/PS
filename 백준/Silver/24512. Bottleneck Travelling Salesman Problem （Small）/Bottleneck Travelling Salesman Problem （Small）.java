import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_007;
	static int ALL;
	static int n;
	static int[][] cost;
	static int[][] dp;
	static int[] path;

	static int getMin(int x, int b) {
		if (b == ALL) {
			return dp[x][b] = cost[x][0] != 0 ? cost[x][0] : INF;
		}
		if (dp[x][b] != -1)
			return dp[x][b];
		else {
			int min = INF;
			int v;
			for (int i = 0; i < n; i++) {
				if ((b & (1 << i)) != 0 || cost[x][i] == 0)
					continue;
				v = Math.max(cost[x][i], getMin(i, b | (1 << i)));

				min = Math.min(min, v);
			}

			return dp[x][b] = min;
		}
	}

	static void track(int x, int b, int ind) {
		path[ind] = x;
		if (b == ALL)
			return;
		else {
			for (int i = 0; i < n; i++) {
				if ((b & (1 << i)) != 0 || cost[x][i] == 0)
					continue;
				else if (dp[x][b] != Math.max(dp[i][b | (1 << i)], cost[x][i])) {
					continue;
				}

				track(i, b | (1 << i), ind + 1);
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		cost = new int[n][n];
		path = new int[n];

		ALL = (1 << n) - 1;
		dp = new int[n][ALL + 1];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		int u, v, c;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			cost[u - 1][v - 1] = c;
		}

		int answer = getMin(0, 1);

		if (answer == INF)
			sb.append(-1).append("\n");
		else {
			track(0, 1, 0);
			sb.append(answer).append("\n");

			for (int p : path) {
				sb.append(p + 1).append(" ");
			}
		}

		System.out.print(sb.toString());
	}
}