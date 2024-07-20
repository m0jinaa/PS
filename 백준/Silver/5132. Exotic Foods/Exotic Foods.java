import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int n;

		int[][] dp;

		int v, answer;

		for (int t = 1; t <= tc; t++) {

			n = Integer.parseInt(br.readLine());

			dp = new int[n + 1][2];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= n; i++) {
				v = Integer.parseInt(st.nextToken());

				dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
				dp[i][1] = dp[i - 1][0] + v;
			}

			answer = Math.max(dp[n][0], dp[n][1]);

			sb.append("Data Set ").append(t).append(":\n").append(answer).append(t == tc ? "\n" : "\n\n");
		}

		System.out.print(sb.toString());
	}
}