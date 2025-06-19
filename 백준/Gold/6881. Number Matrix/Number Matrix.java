import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int n, m;
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

	static boolean checkPossible(int a, int b, int c) {
		boolean possible = false;

		q.clear();
		for (int i = 0; i < n; i++) {
			Arrays.fill(v[i], false);
		}

		for (int i = 0; i < m; i++) {
			if (map[0][i] == a || map[0][i] == b || map[0][i] == c) {
				q.add(new Node(0, i));
				v[0][i] = true;
			}
		}

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == n - 1) {
				possible = true;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || (map[nx][ny] != a && map[nx][ny] != b && map[nx][ny] != c) || v[nx][ny])
					continue;

				v[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}

		return possible;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m];
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x = -1;
		int y = -1;
		int z = -1;

		end: for (int a = 0; a < 10; a++) {
			for (int b = a; b < 10; b++) {
				for (int c = b; c < 10; c++) {
					if (!checkPossible(a, b, c))
						continue;
					x = a;
					y = b;
					z = c;
					break end;
				}
			}
		}

		sb.append(x).append(" ").append(y).append(" ").append(z).append("\n");

		System.out.print(sb.toString());
	}
}