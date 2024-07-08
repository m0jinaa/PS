import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];

		int[] nums = new int[] { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };

		dp[0] = 0;
		dp[1] = -1_000_000_007;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				if (nums[j] > i)
					continue;
				dp[i] = Math.max(dp[i], dp[i - nums[j]] + j);
			}
		}

		System.out.println(dp[n]);
	}
}