import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		int n;

		int[] dp = new int[45];

		dp[0] = dp[1] = 1;

		for (int i = 2; i < 45; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		for (int t = 1; t <= tc; t++) {

			n = Integer.parseInt(br.readLine());

			sb.append("Scenario ").append(t).append(":\n").append(dp[n + 1]).append(t == tc ? "\n" : "\n\n");
		}

		System.out.print(sb.toString());
	}
}