import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] map = new int[r][c];

		int[][][] dp = new int[r][c][n + 1];
		boolean[][] pass = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i][j], INF);
			}
		}

		// pass 체크
		for (int i = 1; i + 1 < r; i++) {
			for (int j = 1; j + 1 < c; j++) {
				// 주행불가지역을 인접하거나 pass 조건에 부합하지 않는곳이면 continue
				if (map[i - 1][j] == -1 || map[i][j + 1] == -1 || map[i + 1][j] == -1 || map[i][j - 1] == -1
						|| map[i - 1][j] <= map[i][j] || map[i + 1][j] <= map[i][j] || map[i][j - 1] >= map[i][j]
						|| map[i][j + 1] >= map[i][j])
					continue;
				pass[i][j] = true;
			}
		}

		// 시작지점 표시
		for (int i = 0; i < r; i++) {
			if (map[i][0] == -1)
				continue;
			dp[i][0][0] = map[i][0];
		}

		int nk;

		for (int j = 0; j + 1 < c; j++) {
			for (int i = 0; i < r; i++) {
				for (int k = 0; k <= n; k++) {
					if (dp[i][j][k] == INF)
						continue;
					for (int dx = -1; dx < 2; dx++) {
						// 맵 벗어나거나 주행불가능한 지역인는경우
						if (i + dx < 0 || i + dx >= r || map[i + dx][j + 1] == -1)
							continue;

						nk = k + (pass[i + dx][j + 1] ? 1 : 0);

						// 지나쳐야하는 pass의 수 초과하는 경우
						if (nk > n)
							continue;

						dp[i + dx][j + 1][nk] = Math.min(dp[i + dx][j + 1][nk], dp[i][j][k] + map[i + dx][j + 1]);
					}
				}
			}
		}

		int answer = INF;

		for (int i = 0; i < r; i++) {
			answer = Math.min(answer, dp[i][c - 1][n]);
		}

		System.out.println(answer == INF ? "impossible" : answer);

	}
}