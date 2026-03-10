import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n + 1][m + 1];
		int[] snow = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			snow[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1);
		}

		// 시작 시 눈덩이 크기는 1
		dp[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dp[i][j] == -1)
					continue;

				// 눈덩이 굴리기
				dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + snow[i + 1]);

				// 눈덩이 던지기
				if (i + 2 <= n) {
					dp[i + 2][j + 1] = Math.max(dp[i + 2][j + 1], (dp[i][j] / 2) + snow[i + 2]);
				}
			}
		}

		int answer = 0;

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				answer = Math.max(answer, dp[i][j]);
			}
		}

		System.out.println(answer);
	}
}