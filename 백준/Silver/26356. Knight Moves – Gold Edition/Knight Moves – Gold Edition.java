import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[][] v;
	static char[][] map;
	static LinkedList<Node> q;

	static int[] dx = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };

	static class Node {
		int x, y, t;

		public Node(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	static boolean inRange(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > n)
			return false;
		return true;
	}

	static int bfs(int sx, int sy, int ex, int ey) {

		q.clear();

		q.add(new Node(sx, sy, 0));
		v[sx][sy] = true;

		Node now;
		int nx, ny;

		int ret = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == ex && now.y == ey) {
				ret = now.t;
				break;
			}

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || v[nx][ny])
					continue;

				v[nx][ny] = true;
				q.add(new Node(nx, ny, now.t + 1));
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int sx, sy, ex, ey;

		q = new LinkedList<>();

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());

			v = new boolean[n + 1][n + 1];

			sb.append("Case #").append(t).append(": ").append(bfs(sx, sy, ex, ey)).append("\n");

			if (t != tc)
				sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}