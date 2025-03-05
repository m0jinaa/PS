import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static final int MAX_N = 1000;
	static BigInteger[] dp;

	static void init() {

		dp = new BigInteger[MAX_N + 1];

		dp[0] = dp[1] = BigInteger.ZERO;
		dp[2] = BigInteger.ONE;

		BigInteger two = new BigInteger("2");

		for (int i = 3; i <= MAX_N; i++) {
			dp[i] = dp[i - 2].multiply(two).add(dp[i - 1]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input;
		int n;

		init();

		while ((input = br.readLine()) != null && !input.isEmpty()) {

			n = Integer.parseInt(input);

			sb.append(dp[n]).append("\n");
		}

		System.out.print(sb.toString());
	}
}