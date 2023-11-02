import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static boolean[][][][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static LinkedList<Pair> q;

	static class Coin {
		int x, y;
		boolean drop;

		public Coin(int x, int y, boolean drop) {
			super();
			this.x = x;
			this.y = y;
			this.drop = drop;
		}
	}

	static class Pair {
		Coin c1, c2;
		int cnt;

		public Pair(Coin c1, Coin c2, int cnt) {
			super();
			this.c1 = c1;
			this.c2 = c2;
			this.cnt = cnt;
		}

	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs() {
		Pair p;
		Coin nc1, nc2;

		int answer = -1;

		int nx1, ny1, nx2, ny2;
		boolean nd1, nd2;

		end: while (!q.isEmpty()) {
			p = q.poll();

			for (int i = 0; i < 4; i++) {
				nx1 = p.c1.x + dx[i];
				ny1 = p.c1.y + dy[i];
				nd1 = false;
				if (!inRange(nx1, ny1))
					nd1 = true;

				if (!nd1 && map[nx1][ny1] == '#') {
					nc1 = p.c1;
				} else {
					nc1 = new Coin(nx1, ny1, nd1);
				}

				nx2 = p.c2.x + dx[i];
				ny2 = p.c2.y + dy[i];
				nd2 = false;
				if (!inRange(nx2, ny2))
					nd2 = true;

				if (!nd2 && map[nx2][ny2] == '#') {
					nc2 = p.c2;
				} else {
					nc2 = new Coin(nx2, ny2, nd2);
				}

				if (nc1.x == nc2.x && nc1.y == nc2.y)
					continue;

				if (nc1.drop ^ nc2.drop) {
					answer = p.cnt + 1;
					break end;
				} else if (nc1.drop)
					continue;

				if (v[nc1.x][nc1.y][nc2.x][nc2.y])
					continue;

				v[nc1.x][nc1.y][nc2.x][nc2.y] = true;
				q.add(new Pair(nc1, nc2, p.cnt + 1));
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

		map = new char[n][];
		q = new LinkedList<>();
		v = new boolean[n][m][n][m];

		Coin c1 = null, c2 = null;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();

			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'o') {
					if (c1 == null) {
						c1 = new Coin(i, j, false);
					} else {
						c2 = new Coin(i, j, false);
					}
				}
			}
		}

		q.add(new Pair(c1, c2, 0));
		v[c1.x][c1.y][c2.x][c2.y] = true;

		int answer = bfs();

		System.out.println(answer);

	}
}