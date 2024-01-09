import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n + 1][4];
		// dp[i][0] : 금방 태어남,dp[i][1] : 아직 성체x, dp[i][2] : 성체(번식o), dp[i][3] : 성체(번식x);
		dp[0][0] = 1;

		int x;

		for (int i = 1; i <= n; i++) {

			dp[i][1] = dp[i - 1][1] + dp[i - 1][0];
			dp[i][2] = dp[i - 1][2];
			dp[i][3] = dp[i - 1][3];

			// 성체되는 짚신벌레
			if (i >= a) {
				x = dp[i - a][0];
				dp[i][2] = (dp[i][2] + x) % MOD;
				dp[i][1] = (dp[i][1] - x + MOD) % MOD;
			}

			if (i >= b) {
				x = dp[i - b][0];
				dp[i][2] = (dp[i][2] - x + MOD) % MOD;
				dp[i][3] = (dp[i][3] + x) % MOD;
			}

			if (i >= d) {
				x = dp[i - d][0];
				dp[i][3] = (dp[i][3] - x + MOD) % MOD;
			}

			dp[i][0] = dp[i][2];
		}

		int answer = (dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3]) % MOD;

		System.out.println(answer);
	}
}