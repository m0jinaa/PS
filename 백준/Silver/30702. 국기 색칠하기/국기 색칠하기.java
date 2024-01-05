import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] A, B;
	static boolean[][] vA, vB, v;
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

	static LinkedList<Node> q;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static void bfs(int x, int y) {
		q.clear();
		q.add(new Node(x, y));
		vA[x][y] = true;
		v[x][y] = true;

		Node now;
		int nx, ny;
		// A
		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || A[nx][ny] != A[x][y] || vA[nx][ny])
					continue;
				vA[nx][ny] = true;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}

		// B
		q.add(new Node(x, y));
		vB[x][y] = true;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || B[nx][ny] != B[x][y] || vB[nx][ny])
					continue;
				vB[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}
	}

	static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (vA[i][j] && vA[i][j] != vB[i][j])
					return false;
			}
		}
		return true;
	}

	public static void clear() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				vA[i][j] = vB[i][j] = false;
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

		A = new char[n][];
		B = new char[n][];
		vA = new boolean[n][m];
		vB = new boolean[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			A[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			B[i] = br.readLine().toCharArray();
		}

		boolean possible = true;

		end: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (v[i][j])
					continue;

				clear();
				bfs(i, j);
				if (!check()) {
					possible = false;
					break end;
				}
			}
		}

		System.out.println(possible ? "YES" : "NO");
	}
}