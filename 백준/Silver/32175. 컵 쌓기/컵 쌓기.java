import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MOD = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[] A = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		long[] dp = new long[h + 1];

		dp[0] = 1;

		for (int i = 0; i <= h; i++) {
			if (dp[i] == 0)
				continue;
			for (int a : A) {
				if (i + a > h)
					continue;
				dp[i + a] = (dp[i + a] + dp[i]) % MOD;
			}
		}

		System.out.println(dp[h]);
	}
}