import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx;
	static int[] dy;
	static int[][] map;
	static boolean[][] v;

	static class Node {
		int x, y, d;

		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= m);
	}

	static int bfs(int sx, int sy, int ex, int ey) {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(sx, sy, 0));
		v[sx][sy] = true;

		Node now;
		int nx, ny;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == ex && now.y == ey) {
				answer = now.d;
				break;
			}

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] != 1 || v[nx][ny])
					continue;

				q.add(new Node(nx, ny, now.d + 1));
				v[nx][ny] = true;
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
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m];

		dx = new int[] { w, w, -w, -w, h, h, -h, -h };
		dy = new int[] { h, -h, h, -h, w, -w, w, -w, };

		int sx = -1, sy = -1, ex = -1, ey = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 3) {
					sx = i;
					sy = j;
					map[i][j] = 1;
				} else if (map[i][j] == 4) {
					ex = i;
					ey = j;
					map[i][j] = 1;
				}
			}
		}

		System.out.println(bfs(sx, sy, ex, ey));
	}
}