import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] dx = new int[][] { { -1, -1, 0, 0, 1, 1 }, { -1, -1, 0, 0, 1, 1 } };
	static int[][] dy = new int[][] { { -1, 0, -1, 1, -1, 0 }, { 0, 1, -1, 1, 0, 1 } };
	static char[][] map;
	static boolean[][] v;

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= m);
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static LinkedList<Node> q;

	static int countBeach(int x, int y) {
		q.clear();
		v[x][y] = true;

		q.add(new Node(x, y));

		Node now;
		int nx, ny;

		int cnt = 0;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 6; i++) {
				nx = now.x + dx[now.x % 2][i];
				ny = now.y + dy[now.x % 2][i];

				if (!inRange(nx, ny) || v[nx][ny])
					continue;
				else if (map[nx][ny] == '.') {
					cnt++;
				} else {
					v[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new boolean[n][m];
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int coast = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '.' || v[i][j])
					continue;
				coast += countBeach(i, j);
			}
		}

		System.out.println(coast);
	}
}