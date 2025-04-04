import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = -1_000_000_007;
		// 이기는 횟수
		int n = Integer.parseInt(br.readLine());

		int[] win = new int[n + 1];

		// 이길 때 얻는 점수 입력받기
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			win[i] = Integer.parseInt(st.nextToken());
		}

		// 지는 횟수
		int m = Integer.parseInt(br.readLine());

		int[] lose = new int[m + 1];

		// 질 때 잃는 점수 입력받기
		st = new StringTokenizer(br.readLine(), " ");

		for (int j = 1; j <= m; j++) {
			lose[j] = Integer.parseInt(st.nextToken());
		}

		// 점수 보호용
		int k = Integer.parseInt(br.readLine());

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], INF);
		}

		dp[0][0] = 0;

		int b;

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 && j == 0)
					continue;
				if (i > 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + win[i]);
				}

				if (j > 0) {
					b = (dp[i][j - 1] % k + k) % k == 0 ? lose[j] : Math.min((dp[i][j - 1] % k + k) % k, lose[j]);
					dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] - b);
				}
			}
		}

		System.out.println(dp[n][m]);
	}
}