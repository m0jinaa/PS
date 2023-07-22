import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0, 1, -1, 1, -1 };
	static int[][] map;
	static boolean[][] v;

	static LinkedList<Node> q;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
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

	static boolean bfs(int x, int y) {

		q.clear();
		q.add(new Node(x, y));
		v[x][y] = true;

		Node now;
		int nx, ny;
		int a, b;

		boolean peak = true;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny))
					continue;
				a = map[nx][ny];
				b = map[now.x][now.y];

				if (a > b) {
					peak = false;
				} else if (a == b && !v[nx][ny]) {
					v[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}

		return peak;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m];

		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (v[i][j] || map[i][j] == 0)
					continue;

				if (bfs(i, j))
					answer++;
			}
		}

		System.out.println(answer);
	}
}