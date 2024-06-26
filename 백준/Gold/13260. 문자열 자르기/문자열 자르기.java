import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] sum;
	static long[][] dp;
	static final long INF = Long.MAX_VALUE;

	static long getMin(int s, int e) {
		if (dp[s][e] != -1)
			return dp[s][e];
		else if (s + 1 == e) {
			return dp[s][e] = 0;
		}

		long cost = INF;

		for (int i = s + 1; i < e; i++) {
			cost = Math.min(cost, getMin(s, i) + getMin(i, e) + sum[e] - sum[s]);
		}

		return dp[s][e] = cost;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		sum = new long[m + 2];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= m; i++) {
			sum[i] = Long.parseLong(st.nextToken());
		}

		sum[m + 1] = n;

		Arrays.sort(sum);

		dp = new long[m + 2][m + 2];

		for (int i = 0; i < m + 2; i++) {
			Arrays.fill(dp[i], -1);
		}

		long answer = getMin(0, m + 1);

		System.out.println(answer);
	}
}