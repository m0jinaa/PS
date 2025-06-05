import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		BigInteger[] dp = new BigInteger[n + 1];

		dp[0] = BigInteger.ONE;
		dp[1] = new BigInteger("3");

		BigInteger two = new BigInteger("2");

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1].multiply(dp[1]);

			for (int j = i - 2; j > 0; j--) {
				dp[i] = dp[i].add(dp[j].multiply(two));
			}

			dp[i] = dp[i].add(two);
		}

		System.out.println(dp[n]);
	}
}