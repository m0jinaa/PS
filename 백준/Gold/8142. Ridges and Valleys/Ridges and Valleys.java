import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dx = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
	static LinkedList<Node> q;
	static int[][] map;
	static boolean[][] v;
	static int ridge, valley;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static void bfs(int x, int y) {
		q.clear();
		q.add(new Node(x, y));
		v[x][y] = true;

		Node now;
		int nx, ny;
		boolean isRidge = true;
		boolean isValley = true;

		int a, b;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny))
					continue;

				a = map[now.x][now.y];
				b = map[nx][ny];

				if (a < b) {
					isRidge = false;
				} else if (a > b) {
					isValley = false;
				} else if (!v[nx][ny]) {
					v[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}

		if (isRidge) {
			ridge++;
		}
		if (isValley) {
			valley++;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		v = new boolean[n][n];
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (v[i][j])
					continue;
				bfs(i, j);
			}
		}

		sb.append(ridge).append(" ").append(valley);

		System.out.println(sb.toString());
	}
}