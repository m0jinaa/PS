import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int ex, ey;
	static int n, m;
	static int[][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		}
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

	static boolean bfs(int sx, int sy) {
		boolean answer = false;

		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(sx, sy));
		v[sx][sy] = 1;
		int nx, ny;
		Node now;
		end: while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny))
					continue;
				if (nx == ex && ny == ey) {
					v[nx][ny]++;
					if (map[nx][ny] == 'X') {
						answer = true;
						break end;
					} else {
						if (v[nx][ny] == 2) {
							answer = true;
							break end;
						}
					}
					q.add(new Node(nx, ny));
				} else {
					if ((v[nx][ny] == 0) && (map[nx][ny] == '.')) {
						v[nx][ny]++;
						q.add(new Node(nx, ny));
					}
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new int[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int sx, sy;

		st = new StringTokenizer(br.readLine(), " ");

		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine(), " ");

		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;

		System.out.println(bfs(sx, sy) ? "YES" : "NO");
	}
}