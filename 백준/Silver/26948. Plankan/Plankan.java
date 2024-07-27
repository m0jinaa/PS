import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			if (i >= 1) {
				dp[i] += dp[i - 1];
			}
			if (i >= 2) {
				dp[i] += dp[i - 2];
			}
			if (i >= 3) {
				dp[i] += dp[i - 3];
			}
		}

		System.out.println(dp[n]);
	}
}