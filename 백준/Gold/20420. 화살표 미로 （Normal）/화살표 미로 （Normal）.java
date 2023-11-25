import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;

	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	static int[][] map;
	static boolean[][][][] v;

	static class Node {
		int x, y, l, r;

		public Node(int x, int y, int l, int r) {
			super();
			this.x = x;
			this.y = y;
			this.l = l;
			this.r = r;

		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static boolean bfs() {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(0, 0, k, k));
		v[0][0][k][k] = true;

		boolean answer = false;

		Node now;
		int nx, ny;

		int d, nc;
		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == n - 1 && now.y == m - 1) {
				answer = true;
				break;

			} else {
				nx = now.x + dx[map[now.x][now.y]];
				ny = now.y + dy[map[now.x][now.y]];

				if (inRange(nx, ny) && !v[nx][ny][now.l][now.r]) {
					v[nx][ny][now.l][now.r] = true;
					q.add(new Node(nx, ny, now.l, now.r));
				}

				nc = Math.min(3, now.l);

				for (int i = 1; i <= nc; i++) {

					d = (map[now.x][now.y] - i + 4) % 4;

					nx = now.x + dx[d];
					ny = now.y + dy[d];

					if (!inRange(nx, ny) || v[nx][ny][now.l - i][now.r])
						continue;
					v[nx][ny][now.l - i][now.r] = true;
					q.add(new Node(nx, ny, now.l - i, now.r));

				}

				nc = Math.min(3, now.r);

				for (int i = 1; i <= nc; i++) {

					d = (map[now.x][now.y] + i) % 4;

					nx = now.x + dx[d];
					ny = now.y + dy[d];

					if (!inRange(nx, ny) || v[nx][ny][now.l][now.r - i])
						continue;
					v[nx][ny][now.l][now.r - i] = true;
					q.add(new Node(nx, ny, now.l, now.r - i));

				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m][k + 1][k + 1];

		char[] row;

		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				switch (row[j]) {
				case 'U':
					map[i][j] = 0;
					break;
				case 'R':
					map[i][j] = 1;
					break;
				case 'D':
					map[i][j] = 2;
					break;
				case 'L':
					map[i][j] = 3;
				}
			}
		}

		boolean answer = bfs();

		System.out.println(answer ? "Yes" : "No");
	}
}