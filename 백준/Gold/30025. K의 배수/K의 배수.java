import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int MOD = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		long[][] dp = new long[m + 1][k];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());

			// 첫번째 자리가 0이 될 경우 제외
			if (nums[i] == 0)
				continue;

			dp[1][nums[i] % k]++;
		}

		int nx;

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < k; j++) {
				if (dp[i][j] == 0)
					continue;

				for (int x : nums) {
					nx = (j * 10 + x) % k;
					dp[i + 1][nx] = (dp[i + 1][nx] + dp[i][j]) % MOD;
				}
			}
		}

		System.out.println(dp[m][0]);
	}
}