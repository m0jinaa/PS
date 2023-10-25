import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dy = new int[] { -1, 1, 2, 2, 1, -1, -2, -2 };
	static boolean[][] v;
	static char[][] map;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean bfs(int sx, int sy, int ex, int ey) {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(sx, sy));
		v[sx][sy] = true;

		boolean answer = false;

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();
			if (now.x == ex && now.y == ey) {
				answer = true;
				break;
			}

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '#' || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}

		return answer;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new boolean[n][m];

		int sx = -1, sy = -1, ex = -1, ey = -1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'H') {
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

		System.out.println(bfs(sx, sy, ex, ey) ? "JA" : "NEJ");
	}
}