import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int[][] map;
	static boolean[][] v;
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

	static void bfs(int x, int y) {
		q.clear();
		q.add(new Node(x, y));
		v[x][y] = true;

		int nx, ny;
		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[nx][ny] == 0 || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();
		v = new boolean[n][m];
		map = new int[n][m];

		int time;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				time = 3;
				while (time-- > 0) {
					map[i][j] += Integer.parseInt(st.nextToken());
				}
			}
		}

		int t = Integer.parseInt(br.readLine()) * 3;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = map[i][j] >= t ? 1 : 0;
			}
		}

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !v[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}