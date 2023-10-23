import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n;
	static int[] dx = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
	static LinkedList<Node> q;
	static char[][] map;
	static int[][] cnt;
	static boolean[][] v;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static int bfs(int x, int y) {
		q.clear();
		q.add(new Node(x, y));
		v[x][y] = true;

		int nx, ny;
		Node now;

		int c = 1;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[nx][ny] == '*' || v[nx][ny])
					continue;
				v[nx][ny] = true;
				c++;
				if (cnt[nx][ny] != 0)
					continue;
				q.add(new Node(nx, ny));
			}
		}
		return c;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		q = new LinkedList<>();

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());

			map = new char[n][];
			cnt = new int[n][n];
			v = new boolean[n][n];

			int nx, ny;

			int total = n * n;

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '*') {
						total--;
						for (int k = 0; k < 8; k++) {
							nx = i + dx[k];
							ny = j + dy[k];
							if (!inRange(nx, ny))
								continue;
							cnt[nx][ny]++;
						}
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != '*' && cnt[i][j] == 0 && !v[i][j]) {
						total -= (bfs(i, j) - 1);
					}
				}
			}
			sb.append("Case #").append(t).append(": ").append(total).append("\n");
		}

		System.out.print(sb.toString());
	}
}