import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static int[][] virus;
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

	static void bfs(int x, int y, int k) {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(x, y));
		int value = map[x][y];
		map[x][y] = k;

		int nx, ny;
		boolean[][] v = new boolean[n][m];

		v[x][y] = true;
		Node now;
		while (!q.isEmpty()) {
			now = q.poll();
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || v[nx][ny] || map[nx][ny] != value)
					continue;
				v[nx][ny] = true;
				map[nx][ny] = k;
				q.add(new Node(nx, ny));

			}
		}

	}

	static boolean checkEqual() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != virus[i][j])
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		virus = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				virus[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		end: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == virus[i][j])
					continue;
				bfs(i, j, virus[i][j]);
				break end;
			}
		}
		String answer = "NO";
		if (checkEqual()) {
			answer = "YES";
		}

		System.out.println(answer);
	}
}