import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static boolean[][] v;
	static char[][] map;
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

	static boolean bfs(int sx, int sy, int ex, int ey) {

		q.clear();

		q.add(new Node(sx, sy));
		v[sx][sy] = true;

		Node now;
		int nx, ny;

		boolean answer = false;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == ex && now.y == ey) {
				answer = true;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[now.x][now.y] != map[nx][ny] || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int sx, sy, ex, ey;

		q = new LinkedList<>();

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			sy = Integer.parseInt(st.nextToken()) - 1;
			sx = n - Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken()) - 1;
			ex = n - Integer.parseInt(st.nextToken());

			map = new char[n][];
			v = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}

			sb.append(bfs(sx, sy, ex, ey) ? "YES\n" : "NO\n");
		}

		System.out.print(sb.toString());
	}
}