import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n;
	static boolean[][] v;
	static char[][] map;
	static LinkedList<Node> q;

	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

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
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static int bfs() {

		q.clear();

		q.add(new Node(0, 0, 0));
		v[0][0] = true;

		Node now;
		int nx, ny;

		int ret = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == n - 1 && now.y == n - 1) {
				ret = now.t;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '*' || v[nx][ny])
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

		q = new LinkedList<>();

		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {

			n = Integer.parseInt(br.readLine());

			map = new char[n][];
			v = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}

			sb.append(bfs()).append("\n");
		}

		System.out.println(sb.toString());
	}
}