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

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static void bfs() {
		if (map[0][0] == 'X')
			return;

		q.clear();

		q.add(new Node(0, 0));
		v[0][0] = true;

		int nx, ny;
		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 'X' || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		q = new LinkedList<>();

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new char[n][];
			v = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}

			bfs();

			sb.append("Case: ").append(t).append("\n");

			// border
			sb.append("+");
			for (int i = 0; i < m; i++) {
				sb.append("---+");
			}
			sb.append("\n");

			for (int i = 0; i < n; i++) {
				sb.append("|");
				for (int j = 0; j < m; j++) {
					sb.append(" ").append(v[i][j] ? "M" : (map[i][j] == 'X' ? "X" : " ")).append(" |");
				}
				sb.append("\n");

				// border
				sb.append("+");
				for (int j = 0; j < m; j++) {
					sb.append("---+");
				}
				sb.append("\n");
			}

			sb.append("Minions").append(v[n - 1][m - 1] ? " can " : " cannot ").append("cross the room\n");
		}

		System.out.print(sb.toString());
	}
}