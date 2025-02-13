import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final long INF = Long.MAX_VALUE;
	static int n;
	static long[][] dp;
	static long[][] cost;

	static void init() {
		for (int s = 1; s < n; s++) {
			for (int i = 0, j = s; i < n && j < n; i++, j++) {
				cost[i][j] = Math.max(cost[i][j - 1], cost[i + 1][j]);
			}
		}
	}

	static long getMin(int s, int e) {
		if (dp[s][e] != -1)
			return dp[s][e];

		long min = INF;

		for (int m = s; m < e; m++) {
			min = Math.min(min, getMin(s, m) + getMin(m + 1, e) + cost[s][m] + cost[m + 1][e]);
		}

		return dp[s][e] = min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		dp = new long[n][n];
		cost = new long[n][n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
			dp[i][i] = 0;
			cost[i][i] = Long.parseLong(st.nextToken());
		}

		init();

		long answer = getMin(0, n - 1);

		System.out.println(answer);
	}
}