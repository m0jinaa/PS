import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[][] v;
	static int[][] map;
	static LinkedList<Node> q;
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

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs(int x, int y) {
		q.clear();
		q.add(new Node(x, y));
		v[x][y] = true;

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] < map[now.x][now.y] || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if (v[i][0])
				cnt++;

			if (m - 1 != 0 && v[i][m - 1])
				cnt++;
		}

		for (int i = 1; i < m - 1; i++) {
			if (v[0][i])
				cnt++;

			if (n - 1 != 0 && v[n - 1][i])
				cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int sx, sy;

		q = new LinkedList<>();

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			sx = Integer.parseInt(st.nextToken()) - 1;
			sy = Integer.parseInt(st.nextToken()) - 1;

			map = new int[n][m];
			v = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("Case #").append(t).append(": ").append(bfs(sx, sy)).append("\n");
		}

		System.out.print(sb.toString());
	}
}