import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, t;
	static long[] dp;

	static long getCnt() {

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = t; j >= i; j--) {
				dp[j] += dp[j - i];
			}
		}

		return dp[t] / 2;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		int sum = (n * (n + 1)) / 2;

		long answer = 0;

		if (sum % 2 == 0) {
			t = sum / 2;
			dp = new long[t + 1];

			answer = getCnt();
		}

		System.out.println(answer);
	}
}