import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int[][][] dp;
	static char[] word = new char[] { 'Y', 'O', 'K', 'O', 'H', 'A', 'M', 'A' };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int getCnt(int x, int y, int d) {
		if (dp[x][y][d] != -1)
			return dp[x][y][d];
		else if (d == 7) {
			return dp[x][y][d] = 1;
		}

		int cnt = 0;

		int nx, ny;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (!inRange(nx, ny) || map[nx][ny] != word[d + 1])
				continue;

			cnt += getCnt(nx, ny, d + 1);
		}

		return dp[x][y][d] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		dp = new int[n][m][8];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 'Y')
					continue;

				answer += getCnt(i, j, 0);
			}
		}

		System.out.println(answer);
	}
}