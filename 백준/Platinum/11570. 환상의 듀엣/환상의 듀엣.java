import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] note = new int[n + 1];

		// dp[i][j] => 상덕이가 i번째, 희원이가 j번째 음을 불렀을때까지의 힘듦의 최솟값
		int[][] dp = new int[n + 1][n + 1];

		final int INF = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			note[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], INF);
		}

		dp[0][1] = 0;
		dp[1][0] = 0;

		int nx;

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				// 같은 음을 부를 일은 없음
				if (i == j)
					continue;

				nx = Math.max(i, j) + 1;

				if (nx > n)
					continue;

				// 처음 부를 때는 차이가 0 임을 기억하기

				// 상덕이가 부름
				dp[nx][j] = Math.min(dp[nx][j], dp[i][j] + (i == 0 ? 0 : Math.abs(note[i] - note[nx])));

				// 희원이가 부름
				dp[i][nx] = Math.min(dp[i][nx], dp[i][j] + (j == 0 ? 0 : Math.abs(note[j] - note[nx])));
			}
		}

		int answer = INF;

		for (int i = 0; i < n; i++) {
			answer = Math.min(answer, dp[i][n]);
			answer = Math.min(answer, dp[n][i]);
		}

		System.out.println(answer);
	}
}