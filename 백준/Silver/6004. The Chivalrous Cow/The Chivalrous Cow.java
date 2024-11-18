import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static boolean[][] v;
	static int[] dx = new int[] { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dy = new int[] { -1, 1, 2, 2, 1, -1, -2, -2 };

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

	static int getCnt(int sx, int sy, int ex, int ey) {
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

				if (!inRange(nx, ny) || map[nx][ny] == '*' || v[nx][ny])
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

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new boolean[n][m];

		int sx = -1, sy = -1;
		int ex = -1, ey = -1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'K') {
					sx = i;
					sy = j;
				} else if (map[i][j] == 'H') {
					ex = i;
					ey = j;
				}
			}
		}

		System.out.println(getCnt(sx, sy, ex, ey));
	}
}