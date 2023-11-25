import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static boolean[][] v;
	static LinkedList<Node> q;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean canGo(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		else if (map[x][y] == '#')
			return false;
		else if (v[x][y])
			return false;
		v[x][y] = true;
		return true;
	}

	static int bfs(int x, int y) {
		q.clear();
		q.add(new Node(x, y));
		v[x][y] = true;

		int nx, ny;
		int cnt = 1;

		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (canGo(nx, ny)) {
					q.add(new Node(nx, ny));
					cnt++;
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		q = new LinkedList<>();

		int x = -1, y = -1;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			map = new char[n][];
			v = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();

				for (int j = 0; j < m; j++) {
					if (map[i][j] == '@') {
						x = i;
						y = j;
						map[i][j] = '.';
					}
				}
			}

			sb.append(bfs(x, y)).append("\n");
		}

		System.out.println(sb.toString());
	}
}