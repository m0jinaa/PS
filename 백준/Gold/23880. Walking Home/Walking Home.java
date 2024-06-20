import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static char[][] map;
	static int[] dx = new int[] { 0, 1 };
	static int[] dy = new int[] { 1, 0 };
	static long[][][][] dp;

	static boolean inRange(int x, int y) {
		if (x <= 0 || y <= 0 || x > n || y > n)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		long answer;
		int nx, ny;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			map = new char[n + 1][];

			for (int i = 1; i <= n; i++) {
				map[i] = (" " + br.readLine()).toCharArray();
			}
			dp = new long[k + 1][2][n + 1][n + 1];

			if (map[1][2] != 'H')
				dp[k][0][1][2] = 1;
			if (map[2][1] != 'H')
				dp[k][1][2][1] = 1;

			for (int x = 1; x <= n; x++) {
				for (int y = 1; y <= n; y++) {
					// (x,y)-> (nx,ny)로 이동
					for (int r = 0; r < 2; r++) {
						nx = x + dx[r];
						ny = y + dy[r];

						if (!inRange(nx, ny) || map[nx][ny] == 'H')
							continue;

						for (int i = 0; i < 2; i++) {
							for (int j = 0; j <= k; j++) {

								if (dp[j][i][x][y] == 0 || (r != i && j == 0))
									continue;

								if (i != r)
									dp[j - 1][r][nx][ny] += dp[j][i][x][y];
								else
									dp[j][r][nx][ny] += dp[j][i][x][y];

							}
						}
					}
				}
			}

			answer = 0;

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < k; j++) {
					answer += dp[j][i][n][n];
				}
			}

			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());

	}
}