import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] nums;

	static void init() {
		nums = new int[9];

		nums[0] = 1;

		for (int i = 1; i <= 8; i++) {
			nums[i] = nums[i - 1] * i;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		init();

		int[] dp = new int[n + 1];

		Arrays.fill(dp, n + 1);

		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int x : nums) {
				if (x > i)
					continue;
				dp[i] = Math.min(dp[i], dp[i - x] + 1);
			}
		}

		System.out.println(dp[n]);
	}
}