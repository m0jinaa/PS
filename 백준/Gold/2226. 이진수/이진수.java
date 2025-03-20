import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N < 2) {
			System.out.println(0);
		} else {
			BigInteger[] dp = new BigInteger[N + 1];

			final BigInteger two = new BigInteger("2");

			dp[0] = BigInteger.ZERO;
			dp[1] = BigInteger.ZERO;
			dp[2] = BigInteger.ONE;

			for (int i = 3; i <= N; i++) {
				dp[i] = two.multiply(dp[i - 2]).add(dp[i - 1]);
			}

			System.out.println(dp[N]);
		}
	}
}