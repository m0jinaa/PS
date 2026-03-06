import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Shark {
		int x, y, d;

		public Shark(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public void setD(int d) {
			this.d = d;
		}

		public void setXY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= n);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int LIMIT = 1000;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int answer = -1;
		int t = 0;
		int remain = m;
		Shark[] sharks = new Shark[m + 1];
		boolean[] expelled = new boolean[m + 1];
		int[][][] dir = new int[m + 1][4][4];
		int[][][] map = new int[n][n][2]; // [x][y][s,t] => x,y자리에 s번 상어의 냄새가 t가되어야 사라진다~

		// 상어 위치 및 냄새 표시
		int v;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				v = Integer.parseInt(st.nextToken());
				map[i][j][0] = v;

				if (v != 0) {
					map[i][j][1] = k;
					sharks[v] = new Shark(i, j);
				}
			}
		}

		// 상어가 바라보는 방향 세팅
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= m; i++) {

			sharks[i].setD(Integer.parseInt(st.nextToken()) - 1);
		}

		// 상어마다 우선순위 입력받기
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int l = 0; l < 4; l++) {
					dir[i][j][l] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}
		// 상어 번호가 작을수록 강력
		// 이동방향 우선순위 : 인접 칸 중 냄새 없는 칸 -> 자신의 냄새가 있는 곳

		int befX, befY, befD;// 상어자신의 냄새가 남아있는 곳 표시용
		int nx, ny;
		boolean moved;
		int[][][] newMap;

		while (t <= LIMIT) {
			if (remain == 1) {
				answer = t;
				break;
			}

			newMap = new int[n][n][2];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					newMap[i][j][0] = map[i][j][0];
					newMap[i][j][1] = map[i][j][1];
				}
			}

			// 1번부터 상어 이동
			for (int i = 1; i <= m; i++) {
				if (expelled[i])// 이미 쫓겨난 상어
					continue;

				moved = false;
				befX = -1;
				befY = -1;
				befD = -1;

				for (int d : dir[i][sharks[i].d]) {
					nx = sharks[i].x + dx[d];
					ny = sharks[i].y + dy[d];

					if (!inRange(nx, ny))
						continue;
					else if (map[nx][ny][0] == 0 || (map[nx][ny][1] <= t)) {
						if (newMap[nx][ny][1] == t + k + 1) {// 이미 먼저 여기로 온 상어가 있다
							expelled[i] = true;
							remain--;
						} else {
							newMap[nx][ny][0] = i;
							newMap[nx][ny][1] = t + k + 1;
							sharks[i].setXY(nx, ny);
							sharks[i].setD(d);
						}

						moved = true;
						break;

					} else if (map[nx][ny][0] == i) {
						if (befX == -1) {
							befX = nx;
							befY = ny;
							befD = d;
						}
					}

				}

				if (!moved) {
					sharks[i].setXY(befX, befY);
					sharks[i].setD(befD);
					newMap[befX][befY][0] = i;
					newMap[befX][befY][1] = t + k + 1;
				}
			}
			map = newMap;
			t++;
		}

		System.out.println(answer);
	}
}