import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int TARGET = 3;
	static final int INF = 1_000_000_007;
	static int n = 5;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= n);
	}

	static int eatApple(int x, int y, int d, int c) {
		if (TARGET == c) {
			return d;
		}
		v[x][y] = true;

		int nx, ny;

		int min = INF;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (!inRange(nx, ny) || map[x][y] == -1 || v[nx][ny])
				continue;
			min = Math.min(min, eatApple(nx, ny, d + 1, c + (map[nx][ny] == 1 ? 1 : 0)));
		}

		v[x][y] = false;

		return min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[n][n];
		v = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());

		int answer = eatApple(sx, sy, 0, 0);

		System.out.println(answer == INF ? -1 : answer);
	}
}