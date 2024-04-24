import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int t, n, m;
	static boolean[][] v;
	static char[][] map;

	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

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

	static boolean inBorder(int x, int y) {
		if (x == 0 || x == n - 1 || y == 0 || y == m - 1)
			return true;
		return false;
	}

	static int bfs(int x, int y) {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(x, y, 0));
		v[x][y] = true;

		Node now;
		int nx, ny;

		int ret = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (inBorder(now.x, now.y)) {
				ret = now.t;
				break;
			}

			if (now.t == t)
				continue;

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '1' || v[nx][ny])
					continue;
				else if ((map[nx][ny] == 'U' && i != 2) || (map[nx][ny] == 'D' && i != 3)
						|| (map[nx][ny] == 'L' && i != 0) || (map[nx][ny] == 'R' && i != 1))
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

		t = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new boolean[n][m];

		int sx = -1, sy = -1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'S') {
					sx = i;
					sy = j;
					map[i][j] = '0';
				}
			}
		}

		int answer = bfs(sx, sy);

		System.out.println(answer == -1 ? "NOT POSSIBLE" : answer);
	}
}