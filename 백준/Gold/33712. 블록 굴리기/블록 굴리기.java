import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[][] map;
	static int[][][][] dp;
	static int[][] dx = new int[][] { { -2, 0, 1, 0 }, { -1, 0, 1, 0 }, { -1, 0, 2, 0 } };
	static int[][] dy = new int[][] { { 0, 1, 0, -2 }, { 0, 2, 0, -1 }, { 0, 1, 0, -1 } };
	static int[][] ds = new int[][] { { 2, 1, 2, 1 }, { 1, 0, 1, 0 }, { 0, 2, 0, 2 } };

	static boolean canPlace(int x, int y, int s) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		else if (map[x][y] == 0)
			return false;
		else if (s == 1 && (y + 1 >= m || map[x][y + 1] == 0))
			return false;
		else if (s == 2 && (x + 1 >= n || map[x + 1][y] == 0))
			return false;

		return true;
	}

	// (x,y)지점에 s의 형태로 놓여있고 현재까지 c번 움직였을 때 목표지점에 k번만에 도달할 수 있는지 여부 구하기
	static int findPossible(int x, int y, int c, int s) {
		if (dp[x][y][c][s] != -1)
			return dp[x][y][c][s];
		else if (c == k) {
			return dp[x][y][c][s] = 0;
		}
		int ret = 0;
		int nx, ny, ns;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[s][i];
			ny = y + dy[s][i];
			ns = ds[s][i];

			if (!canPlace(nx, ny, ns))
				continue;

			ret |= findPossible(nx, ny, c + 1, ns);

		}

		return dp[x][y][c][s] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new int[n][m][k + 1][3];
		map = new int[n][m];

		int ex = -1;
		int ey = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					ex = i;
					ey = j;
				}

				for (int h = 0; h <= k; h++) {
					Arrays.fill(dp[i][j][h], -1);
				}
			}
		}

		dp[ex][ey][k][0] = 1;

		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 1)
					continue;
				answer += findPossible(i, j, 0, 0);
			}
		}

		System.out.println(answer);
	}
}