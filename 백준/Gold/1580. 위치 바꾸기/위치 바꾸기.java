import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
	static char[][] map;
	static boolean[][][][] v;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static class Pair {
		int ax, ay, bx, by;
		int c;

		public Pair(int ax, int ay, int bx, int by, int c) {
			super();
			this.ax = ax;
			this.ay = ay;
			this.bx = bx;
			this.by = by;
			this.c = c;
		}
	}

	static int bfs(int ax, int ay, int bx, int by) {

		int answer = -1;

		Pair p;

		int nax, nay, nbx, nby;

		LinkedList<Pair> q = new LinkedList<>();

		q.add(new Pair(ax, ay, bx, by, 0));

		v[ax][ay][bx][by] = true;

		while (!q.isEmpty()) {
			p = q.poll();

			if (ax == p.bx && ay == p.by && bx == p.ax && by == p.ay) {
				answer = p.c;
				break;
			}

			// a, b 둘 다 움직이기
			for (int i = 0; i < 8; i++) {
				nax = p.ax + dx[i];
				nay = p.ay + dy[i];

				if (!inRange(nax, nay) || map[nax][nay] == 'X')
					continue;

				for (int j = 0; j < 8; j++) {
					nbx = p.bx + dx[j];
					nby = p.by + dy[j];

					if (!inRange(nbx, nby) || map[nbx][nby] == 'X')
						continue;

					// 같은 칸에 들어가거나, 교차하거나, 이미 갔었던 곳인 경우
					if ((nax == nbx && nay == nby) || ((nax == p.bx && nay == p.by) && (p.ax == nbx && p.ay == nby))
							|| v[nax][nay][nbx][nby])
						continue;
					v[nax][nay][nbx][nby] = true;
					q.add(new Pair(nax, nay, nbx, nby, p.c + 1));
				}
			}

			// a만 움직이기
			for (int i = 0; i < 8; i++) {
				nax = p.ax + dx[i];
				nay = p.ay + dy[i];

				if (!inRange(nax, nay) || map[nax][nay] == 'X')
					continue;

				if ((p.bx == nax && p.by == nay) || v[nax][nay][p.bx][p.by])
					continue;
				v[nax][nay][p.bx][p.by] = true;

				q.add(new Pair(nax, nay, p.bx, p.by, p.c + 1));
			}
			// b만 움직이기
			for (int i = 0; i < 8; i++) {
				nbx = p.bx + dx[i];
				nby = p.by + dy[i];

				if (!inRange(nbx, nby) || map[nbx][nby] == 'X')
					continue;

				if ((p.ax == nbx && p.ay == nby) || v[p.ax][p.ay][nbx][nby])
					continue;

				v[p.ax][p.ay][nbx][nby] = true;
				q.add(new Pair(p.ax, p.ay, nbx, nby, p.c + 1));
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

		v = new boolean[n][m][n][m];
		map = new char[n][];

		int ax = -1, ay = -1, bx = -1, by = -1;
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'A') {
					ax = i;
					ay = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					bx = i;
					by = j;
					map[i][j] = '.';
				}
			}
		}

		int answer = bfs(ax, ay, bx, by);

		System.out.println(answer);
	}
}