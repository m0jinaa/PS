import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		int n, m, start, s, e;
		long answer;
		long[][] dp;
		int[] p = new int[11];

		p[0] = 1;

		for (int i = 1; i < 11; i++) {
			p[i] = p[i - 1] * 2;
		}

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			dp = new long[n + 1][m + 1];

			start = m / p[n - 1];

			for (int i = 1; i <= start; i++) {
				dp[1][i] = 1;
			}

			for (int i = 1; i < n; i++) {
				for (int j = 1; j <= m; j++) {
					if (dp[i][j] == 0)
						continue;
					s = j * 2;
					e = m / p[n - i - 1];

					for (int k = s; k <= e; k++) {
						dp[i + 1][k] += dp[i][j];
					}
				}
			}
			answer = 0;

			for (int i = 1; i <= m; i++) {
				answer += dp[n][i];
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}