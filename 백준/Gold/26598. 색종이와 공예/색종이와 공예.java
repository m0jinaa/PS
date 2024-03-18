import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
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

	static char[][] map;
	static boolean[][] v;

	static LinkedList<Node> q;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static boolean bfs(int x, int y) {
		q.clear();

		q.add(new Node(x, y));
		v[x][y] = true;

		int nx, ny;

		int cnt = 1;
		int sx = x;
		int sy = y;
		int ex = x;
		int ey = y;
		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] != map[x][y] || v[nx][ny])
					continue;
				q.add(new Node(nx, ny));
				v[nx][ny] = true;
				cnt++;

				sx = Math.min(sx, nx);
				sy = Math.min(sy, ny);
				ex = Math.max(ex, nx);
				ey = Math.max(ey, ny);
			}
		}

		int r = ex - sx + 1;
		int c = ey - sy + 1;

		return r * c == cnt;
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

		boolean answer = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (v[i][j])
					continue;
				answer &= bfs(i, j);
			}
		}

		System.out.println(answer ? "dd" : "BaboBabo");
	}
}