import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		final int INF = 10001;
		
		int n, m, amount, cnt;
		int[] dp;
		int[] coins;

		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {

			n = Integer.parseInt(br.readLine());

			dp = new int[INF];

			m = Integer.parseInt(br.readLine());

			coins = new int[m];

			for (int i = 0; i < m; i++) {
				coins[i] = Integer.parseInt(br.readLine());
			}

			Arrays.fill(dp, INF);

			dp[0] = 0;

			for (int c : coins) {
				for (int x = 10000; x >= c; x--) {
					dp[x] = Math.min(dp[x], dp[x - c] + 1);
				}
			}

			amount = -1;
			cnt = -1;

			for (int i = n; i <= INF; i++) {
				if (dp[i] != INF) {
					amount = i;
					cnt = dp[i];
					break;
				}
			}

			sb.append(amount).append(" ").append(cnt).append("\n");
		}

		System.out.print(sb.toString());
	}
}