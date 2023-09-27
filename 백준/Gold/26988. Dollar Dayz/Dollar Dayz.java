import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BigInteger[] dp;
	static int n;

	static BigInteger fill(int x) {
		dp[0] = BigInteger.ONE;

		for (int i = 1; i <= x; i++) {
			for (int j = i; j <= n; j++) {
				dp[j] = dp[j].add(dp[j - i]);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		dp = new BigInteger[n + 1];

		Arrays.fill(dp, BigInteger.ZERO);

		System.out.println(fill(k));
	}
}