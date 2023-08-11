import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int[][] v;
	static int[][] map;
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

		int nx, ny;

		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] != 0 || v[nx][ny] != -1)
					continue;

				v[nx][ny] = v[now.x][now.y] + 1;

				q.add(new Node(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new int[n][m];
		q = new LinkedList<>();
		char[] row;
		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = row[j] - '0';
				v[i][j] = -1;
				if (map[i][j] == 1) {
					v[i][j] = 0;
					q.add(new Node(i, j));
				}
			}
		}

		bfs();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(v[i][j]).append(j == m - 1 ? "\n" : " ");
			}
		}

		System.out.println(sb.toString());
	}
}