import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, t, ex, ey;
	static long[][][] dp;
	static char[][] map;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static long getCnt(int x, int y, int c) {
		if (dp[x][y][c] != -1)
			return dp[x][y][c];
		else if (x == ex && y == ey && c == t)
			return dp[x][y][c] = 1;
		else if (c == t) {
			return dp[x][y][c] = 0;
		}
		long cnt = 0;
		int nx, ny, nc;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			nc = c + 1;
			if (!inRange(nx, ny) || map[nx][ny] == '*')
				continue;
			cnt += getCnt(nx, ny, nc);
		}

		return dp[x][y][c] = cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new char[n][];

		dp = new long[n][m][t + 1];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		int sx, sy;

		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;
		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;

		long answer = 0;

		if (map[sx][sy] != '*' && map[ex][ey] != '*')
			answer = getCnt(sx, sy, 0);

		System.out.println(answer);
	}
}