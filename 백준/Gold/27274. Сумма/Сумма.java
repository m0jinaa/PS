import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		BigInteger[] dp = new BigInteger[n + 1];

		Arrays.fill(dp, BigInteger.ZERO);
		dp[0] = BigInteger.ONE;

		for (int x = 1; x <= n; x += 2) {
			for (int i = x; i <= n; i++) {
				dp[i] = dp[i].add(dp[i - x]);
			}
		}
		System.out.println(dp[n]);
	}
}