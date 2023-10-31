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

	static LinkedList<Node> q;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static void bfs() {

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (map[nx][ny] == '+') {
					while (map[nx][ny] == '+' && map[nx + dx[i]][ny + dy[i]] != '#') {
						nx += dx[i];
						ny += dy[i];
					}
				}

				if (map[nx][ny] == '#' || v[nx][ny])
					continue;

				v[nx][ny] = true;

				if (map[nx][ny] == 'P')
					map[nx][ny] = '.';

				q.add(new Node(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new boolean[n][m];
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'W') {
					q.add(new Node(i, j));
					v[i][j] = true;
				} else if (map[i][j] == '.') {
					map[i][j] = 'P';
				}
			}
		}

		bfs();

		for (char[] row : map) {
			sb.append(String.valueOf(row)).append("\n");
		}

		System.out.print(sb.toString());

	}
}