import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][][][] v;
	static int[][] map;
	static int[] knightX = new int[] { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] knightY = new int[] { -1, 1, 2, 2, 1, -1, -2, -2 };
	static int[] bishopX = new int[] { -1, -1, 1, 1 };
	static int[] bishopY = new int[] { -1, 1, 1, -1 };
	static int[] rookX = new int[] { 0, 0, 1, -1 };
	static int[] rookY = new int[] { 1, -1, 0, 0 };

	static class Pieces {
		int x, y, type, last, time, change;

		public Pieces(int x, int y, int type, int last, int time, int change) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
			this.last = last;
			this.time = time;
			this.change = change;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static void getMin(int x, int y) {
		LinkedList<Pieces> q = new LinkedList<>();

		q.add(new Pieces(x, y, 0, 1, 0, 0));
		q.add(new Pieces(x, y, 1, 1, 0, 0));
		q.add(new Pieces(x, y, 2, 1, 0, 0));
		v[x][y][0][1] = 0;
		v[x][y][1][1] = 0;
		v[x][y][2][1] = 0;

		Pieces p;
		int nx, ny, nl;
		int time = Integer.MAX_VALUE;
		int change = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			p = q.poll();

            if (p.last == m) {
				if (time > p.time) {
					time = p.time;
					change = p.change;
				} else if (time == p.time) {
					change = Math.min(change, p.change);
				}
				continue;
			}

			if (p.type == 0) {// 나이트

				for (int i = 0; i < 8; i++) {
					nx = p.x + knightX[i];
					ny = p.y + knightY[i];

					if (!inRange(nx, ny))
						continue;
					nl = ((map[nx][ny] == p.last + 1) ? (p.last + 1) : p.last);

					if (v[nx][ny][p.type][nl] <= p.change)
						continue;
					v[nx][ny][p.type][nl] = p.change;
					q.add(new Pieces(nx, ny, p.type, nl, p.time + 1, p.change));
				}
			} else if (p.type == 1) {// 비숍
				for (int i = 0; i < 4; i++) {
					nx = p.x + bishopX[i];
					ny = p.y + bishopY[i];
					while (inRange(nx, ny)) {
						nl = ((map[nx][ny] == p.last + 1) ? (p.last + 1) : p.last);

						if (v[nx][ny][p.type][nl] > p.change) {
							v[nx][ny][p.type][nl] = p.change;
							q.add(new Pieces(nx, ny, p.type, nl, p.time + 1, p.change));
						}
						nx += bishopX[i];
						ny += bishopY[i];
					}
				}

			} else {// 룩
				for (int i = 0; i < 4; i++) {
					nx = p.x + rookX[i];
					ny = p.y + rookY[i];
					while (inRange(nx, ny)) {
						nl = ((map[nx][ny] == p.last + 1) ? (p.last + 1) : p.last);

						if (v[nx][ny][p.type][nl] > p.change) {
							v[nx][ny][p.type][nl] = p.change;
							q.add(new Pieces(nx, ny, p.type, nl, p.time + 1, p.change));
						}
						nx += rookX[i];
						ny += rookY[i];
					}
				}
			}

			// 말 변경
			for (int i = 0; i < 3; i++) {
				if (v[p.x][p.y][i][p.last] <= p.change + 1)
					continue;
				v[p.x][p.y][i][p.last] = p.change + 1;
				q.add(new Pieces(p.x, p.y, i, p.last, p.time + 1, p.change + 1));
			}
		}

		System.out.println(time + " " + change);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = n * n;

		map = new int[n][n];
		v = new int[n][n][3][m + 1];

		int sx = 0, sy = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					sx = i;
					sy = j;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 3; k++) {
					Arrays.fill(v[i][j][k], Integer.MAX_VALUE);
				}
			}
		}

		getMin(sx, sy);
	}
}