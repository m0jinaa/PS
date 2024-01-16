import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, c;
	static int[][][][] dp;
	static final int MOD = 1_000_007;
	static int[][] map;
	static int[] dx = new int[] { 0, -1 };
	static int[] dy = new int[] { -1, 0 };

	static int getCnt(int x, int y, int c, int ind) {
		if (dp[x][y][c][ind] != -1)
			return dp[x][y][c][ind];

		// 현재위치가 오락실인데 마지막방문오락실 번호와 일치하지 않을 경우
		if (map[x][y] != 0 && map[x][y] != ind)
			return dp[x][y][c][ind] = 0;

		// 방문한 오락실의 수가 마지막 방문 오락실 번호보다 큰 경우
		if (c > ind || (c == 0 && ind != 0))
			return dp[x][y][c][ind] = 0;

		int cnt = 0;
		int nx, ny;

		if (map[x][y] != 0) {
			for (int i = 0; i < 2; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				for (int j = 0; j < ind; j++) {
					cnt = (cnt + getCnt(nx, ny, c - 1, j)) % MOD;
				}
			}
		} else {
			for (int i = 0; i < 2; i++) {
				nx = x + dx[i];
				ny = y + dy[i];

				cnt = (cnt + getCnt(nx, ny, c, ind)) % MOD;
			}
		}

		return dp[x][y][c][ind] = cnt;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];

		// dp[x좌표][y좌표][방문한오락실수][마지막방문오락실번호]
		dp = new int[n + 1][m + 1][c + 1][c + 1];

		int x, y;

		for (int i = 1; i <= c; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			map[x][y] = i;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int k = 0; k <= c; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}

		if (map[1][1] == 0) {
			dp[1][1][0][0] = 1;
		} else {
			dp[1][1][1][map[1][1]] = 1;
		}

		int cnt = 0;

		for (int i = 0; i <= c; i++) {
			cnt = 0;
			for (int j = i; j <= c; j++) {
				cnt = (cnt + getCnt(n, m, i, j)) % MOD;
			}
			sb.append(cnt).append(i == c ? "\n" : " ");
		}

		System.out.println(sb.toString());
	}
}