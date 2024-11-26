import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] map;
	static boolean[][] v;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static LinkedList<Node> q;

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= m);
	}

	static int bfs(int x, int y) {
		q.clear();

		q.add(new Node(x, y));
		v[x][y] = true;

		Node now;
		int nx, ny;

		int cnt = 1;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] != '.' || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int sx, sy;

		q = new LinkedList<>();

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			sx = -1;
			sy = -1;

			map = new char[n][];
			v = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();

				for (int j = 0; j < m; j++) {
					if (map[i][j] == 'A') {
						sx = i;
						sy = j;
						map[i][j] = '.';
						break;
					}
				}
			}

			sb.append(bfs(sx, sy)).append("\n");
		}

		System.out.print(sb.toString());
	}
}