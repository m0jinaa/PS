import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n;
		int[] dp = new int[41];

		dp[0] = dp[1] = 1;

		for (int i = 2; i < 41; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			sb.append(dp[n]).append("\n");
		}

		System.out.println(sb.toString());
	}
}