import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int getDist(int x, int y) {
		return Math.abs(x % 3 - y % 3) + Math.abs(x / 3 - y / 3);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] order = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		// dp[누르는 순서][왼손 위치][오른손 위치]
		int[][][] dp = new int[n + 1][12][12];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < 12; j++) {
				Arrays.fill(dp[i][j], INF);
			}
		}

		for (int i = 1; i <= n; i++) {
			order[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		dp[0][0][2] = 0;

		int d;

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 12; j++) {
					if (dp[k][i][j] == INF)
						continue;

					// 왼손으로 누르기
					d = getDist(i, order[k + 1]) + a + dp[k][i][j];

					dp[k + 1][order[k + 1]][j] = Math.min(dp[k + 1][order[k + 1]][j], d);

					// 오른손으로 누르기
					d = getDist(j, order[k + 1]) + b + dp[k][i][j];

					dp[k + 1][i][order[k + 1]] = Math.min(dp[k + 1][i][order[k + 1]], d);
				}
			}
		}
		int answer = INF;

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				answer = Math.min(answer, dp[n][i][j]);
			}
		}
		System.out.println(answer);
	}
}