import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][][] dp;
	static int MAX = 20;
	static final int INF = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		dp = new int[MAX + 1][MAX + 1][MAX * MAX + 1];

		for (int i = 0; i <= MAX; i++) {
			for (int j = 0; j <= MAX; j++) {
				Arrays.fill(dp[i][j], INF);
				dp[i][j][1] = i * j;
			}
		}

		// init

		for (int z = 2; z <= MAX * MAX; z++) {
			for (int x = 1; x <= MAX; x++) {
				for (int y = 1; y <= MAX; y++) {

					// 가로로 자르기
					for (int i = 1; i < x; i++) {
						for (int j = 1; j < z; j++) {
							if (dp[i][y][j] == INF || dp[x - i][y][z - j] == INF)
								continue;
							dp[x][y][z] = Math.min(dp[x][y][z], Math.max(dp[i][y][j], dp[x - i][y][z - j]));
						}
					}

					// 세로로 자르기
					for (int i = 1; i < y; i++) {
						for (int j = 1; j < z; j++) {
							if (dp[x][i][j] == INF || dp[x][y - i][z - j] == INF)
								continue;
							dp[x][y][z] = Math.min(dp[x][y][z], Math.max(dp[x][i][j], dp[x][y - i][z - j]));
						}
					}
				}
			}
		}

		int x, y, z;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());

			if (x == 0 && y == 0 && z == 0)
				break;

			sb.append(dp[x][y][z]).append("\n");
		}

		System.out.print(sb.toString());
	}
}