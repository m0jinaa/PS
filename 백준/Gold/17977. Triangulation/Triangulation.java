import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if (n == 3) {
			System.out.println(0);
		} else {
			int[] dp = new int[n + 1];

			dp[4] = 1;

			for (int i = 5; i <= n; i++) {
				dp[i] = dp[(i + 1) / 2] + 2;
			}

			System.out.println(dp[n]);
		}
	}
}