import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[][] v;
	static char[][] map;

	static int[] dx = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };

	static class Node {
		int x, y, t;

		public Node(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs(int sx, int sy, int ex, int ey) {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(sx, sy, 0));
		v[sx][sy] = true;

		Node now;
		int nx, ny;

		int ret = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == ex && now.y == ey) {
				ret = now.t;
				break;
			}

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 'x' || v[nx][ny])
					continue;

				v[nx][ny] = true;
				q.add(new Node(nx, ny, now.t + 1));
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new boolean[n][m];

		int sx = -1, sy = -1;
		int ex = -1, ey = -1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'z') {
					sx = i;
					sy = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'n') {
					ex = i;
					ey = j;
					map[i][j] = '.';
				}
			}
		}

		int answer = bfs(sx, sy, ex, ey);

		System.out.println(answer == -1 ? "NIE" : answer);
	}
}