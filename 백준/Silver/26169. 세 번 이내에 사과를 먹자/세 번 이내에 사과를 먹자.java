import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n = 5;
	static int[][] map;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static boolean move(int x, int y, int d, int c) {
		if (d == 3) {
			return c >= 2;
		} else {
			int nx, ny, nc;

			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == -1)
					continue;

				nc = c + map[nx][ny];

				map[nx][ny] = -1;
				if (move(nx, ny, d + 1, nc))
					return true;
				map[nx][ny] = nc - c;
			}

			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		map[r][c] = -1;

		int possible = move(r, c, 0, 0) ? 1 : 0;

		System.out.println(possible);

	}
}