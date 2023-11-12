import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] sum;
	static int[] dp;
	static final int INF = -1_000_000_007;

	static int getMax(int ind) {
		if (ind > n)
			return 0;
		if (dp[ind] != INF)
			return dp[ind];

		int max = INF;

		max = Math.max(max, sum[ind] - sum[ind - 1] + getMax(ind + 1));

		max = Math.max(max, 2 * (sum[ind + 2] - sum[ind - 1]) + getMax(ind + 3));

		return dp[ind] = max;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		sum = new int[n + 3];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}
		sum[n + 1] = sum[n + 2] = sum[n];

		dp = new int[n + 3];
		Arrays.fill(dp, INF);
		dp[n + 1] = dp[n + 2] = 0;

		int answer = getMax(1);

		System.out.println(answer);
	}
}