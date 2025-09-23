import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] hanger = new int[] { 0, 1, 3, 7, 15 };
		int[] canHang = new int[] { 0, 1, 2, 4, 0 };

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}

		dp[0][0] = 0;

		int answer = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= m; j++) {
				if (dp[i][j] == -1)
					continue;

				for (int k = 1; k <= 4 && hanger[k] + j <= m; k++) {
					dp[i + 1][hanger[k] + j] = Math.max(dp[i + 1][hanger[k] + j], dp[i][j] + canHang[k]);
				}
			}

			answer = Math.max(answer, dp[i + 1][m]);
		}

		System.out.println(answer);
	}
}