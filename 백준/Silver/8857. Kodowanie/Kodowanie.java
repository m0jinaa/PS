import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;

	static void init() {
		dp = new int[46];

		dp[1] = 1;

		for (int i = 2; i < 46; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		init();

		int n;

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			sb.append(dp[n]).append("\n");
		}

		System.out.print(sb.toString());
	}
}