import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		int n;

		int[] dp = new int[45];

		dp[1] = 2;
		dp[2] = 3;

		for (int i = 3; i < 45; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		for (int t = 1; t <= tc; t++) {

			n = Integer.parseInt(br.readLine());

			if (t != 1)
				sb.append("\n");

			sb.append("Scenario #").append(t).append(":\n").append(dp[n]).append("\n");
		}

		System.out.print(sb.toString());
	}
}