import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] boost;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int answer = 0;
		boost = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			boost[i][0] = Integer.parseInt(st.nextToken());
			boost[i][1] = Integer.parseInt(st.nextToken());
		}

		dp = new int[k + 1][5002];

		for (int i = 0; i <= k; i++) {
			Arrays.fill(dp[i], -1);
		}

		dp[0][1] = 0;

		for (int i = 0; i < k; i++) {
			for (int j = 0; j <= 5001; j++) {
				if (dp[i][j] == -1)
					continue;
				// 구매x
				dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + j);
                   
                // 구매
				for (int[] b : boost) {
					if (dp[i][j] >= b[0]) {
						dp[i + 1][j + b[1]] = Math.max(dp[i + 1][j + b[1]], dp[i][j] - b[0]);
					}
				}
			}
		}

		for (int i = 0; i <= 5001; i++) {
			answer = Math.max(answer, dp[k][i]);
		}

		System.out.println(answer);
	}
}