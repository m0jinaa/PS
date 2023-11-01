import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, u;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int[][] v;
	static char[][] map;
	static LinkedList<Node> q;

	static class Node {
		int x, y;
		int h;
		int u;
		int d;

		public Node(int x, int y, int h, int u, int d) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;
			this.u = u;
			this.d = d;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static int bfs(int ex, int ey) {

		Node now;
		int nx, ny, nh, nu, nd;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == ex && now.y == ey) {
				answer = now.d;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny))
					continue;
				nh = now.h;
				nu = now.u;
				nd = now.d + 1;

				if (map[nx][ny] == 'U')
					nu = u;

				if (map[nx][ny] != 'E') {
					if (nu != 0)
						nu--;
					else
						nh--;
				}

				if (nh == 0 || v[nx][ny] >= nh + nu)
					continue;

				v[nx][ny] = nh + nu;
				q.add(new Node(nx, ny, nh, nu, nd));

			}
		}

		return answer;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();

		map = new char[n][];
		v = new int[n][n];

		int ex = -1, ey = -1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'S') {
					q.add(new Node(i, j, h, 0, 0));
					v[i][j] = h;
				} else if (map[i][j] == 'E') {
					ex = i;
					ey = j;
				}
			}
		}

		int answer = bfs(ex, ey);

		System.out.println(answer);
	}
}