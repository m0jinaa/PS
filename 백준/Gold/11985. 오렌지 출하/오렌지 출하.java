import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long[] orange = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			orange[i] = Long.parseLong(br.readLine());
		}

		long[] dp = new long[n + 1];

		Arrays.fill(dp, Long.MAX_VALUE);
		dp[0] = 0;

		long min, max;

		for (int e = 1; e <= n; e++) {
			min = orange[e];
			max = orange[e];
			for (int s = e; s > 0 && e - s + 1 <= m; s--) {
				min = Math.min(min, orange[s]);
				max = Math.max(max, orange[s]);

				dp[e] = Math.min(dp[e], dp[s - 1] + k + (e - s + 1) * (max - min));
			}
		}

		System.out.println(dp[n]);
	}
}