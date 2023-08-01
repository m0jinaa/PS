import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int ex, ey;
	static boolean[][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] map;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static boolean dfs(int x, int y) {
		v[x][y] = true;
		if (x == ex && y == ey)
			return true;
		int nx, ny;
		boolean success = false;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (!inRange(nx, ny) || map[nx][ny] != '.' || v[nx][ny])
				continue;
			if (dfs(nx, ny)) {
				success = true;
			}
		}
		if (!success)
			map[x][y] = '@';
		return success;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new boolean[n][m];

		int sx = -1, sy = -1;
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && map[i][j] == '.') {
					if (sx == -1) {
						sx = i;
						sy = j;
					} else {
						ex = i;
						ey = j;
					}
				}
			}
		}

		dfs(sx, sy);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (v[i][j])
					continue;
				if (map[i][j] == '.')
					map[i][j] = '@';
			}
			sb.append(String.valueOf(map[i])).append("\n");
		}

		System.out.println(sb.toString());

	}
}