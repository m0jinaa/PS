import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] soldier;
	static char[][] map;
	static int[][] princess;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

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

	static void soldierMove() {

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '#' || soldier[nx][ny] != -1)
					continue;
				soldier[nx][ny] = soldier[now.x][now.y] + 1;

				q.add(new Node(nx, ny));
			}
		}
	}

	static boolean princessMove(int sx, int sy, int ex, int ey) {
		q.clear();
		q.add(new Node(sx, sy));
		princess[sx][sy] = 0;

		Node now;
		int nx, ny;

		boolean possible = false;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == ex && now.y == ey) {
				possible = true;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '#' || princess[nx][ny] != -1
						|| (soldier[nx][ny] != -1 && soldier[nx][ny] <= princess[now.x][now.y] + 1))
					continue;
				princess[nx][ny] = princess[now.x][now.y] + 1;

				q.add(new Node(nx, ny));
			}
		}

		return possible;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		princess = new int[n][m];
		soldier = new int[n][m];
		q = new LinkedList<>();

		int sx = -1, sy = -1, ex = -1, ey = -1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(princess[i], -1);
			Arrays.fill(soldier[i], -1);
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '@') {
					sx = i;
					sy = j;
				} else if (map[i][j] == '%') {
					ex = i;
					ey = j;
				} else if (map[i][j] == '$') {
					q.add(new Node(i, j));
					soldier[i][j] = 0;
				}
			}
		}

		soldierMove();

		boolean answer = princessMove(sx, sy, ex, ey);

		System.out.println(answer ? "Yes" : "No");

	}
}