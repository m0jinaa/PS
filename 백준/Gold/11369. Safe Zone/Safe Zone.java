import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n, p, q, j, k;

		long[][] dp;
		long answer;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			if (n == 0)
				break;

			dp = new long[k + 1][n];

			dp[0][j] = 1;

			for (int i = 0; i < k; i++) {
				for (int w = 0; w < n; w++) {
					if (dp[i][w] == 0)
						continue;
					if (w > 0) {
						dp[i + 1][w - 1] += dp[i][w];
					}

					if (w < n - 1) {
						dp[i + 1][w + 1] += dp[i][w];
					}
				}
			}

			answer = 0;

			for (int i = p; i <= q; i++) {
				answer += dp[k][i];
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}