import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, rainbow;
	static int[][] map;
	static boolean[][] v, selected;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static LinkedList<Point> q;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static int bfs(int x, int y) {
		int cnt = 1;
		rainbow = 0;
		q.clear();

		q.add(new Point(x, y));

		v[x][y] = true;
		selected[x][y] = true;

		Point now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == m + 1 || (map[nx][ny] != 0 && map[nx][ny] != map[x][y])
						|| v[nx][ny])
					continue;

				v[nx][ny] = true;
				selected[nx][ny] = true;

				cnt++;
				if (map[nx][ny] == 0) {
					rainbow++;
				}
				q.add(new Point(nx, ny));
			}
		}
		return cnt;
	}

	static void rotate() {
		// 반시계방향 90도 -> 좌우 반전 -> 좌측 상단 방향 대각선 기준 반전
		// 좌우반전
		int temp;
		for (int j = 0; j < n / 2; j++) {
			for (int i = 0; i < n; i++) {
				temp = map[i][j];
				map[i][j] = map[i][n - 1 - j];
				map[i][n - 1 - j] = temp;
			}
		}

		// 좌측 상단 방향 대각선 기준 반전
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				temp = map[i][j];
				map[i][j] = map[j][i];
				map[j][i] = temp;
			}
		}
	}

	static void gravity() {
		int diff;
		for (int j = 0; j < n; j++) {
			diff = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (map[i][j] == m + 1) {
					diff++;
				} else if (map[i][j] == -1) {// 벽돌
					diff = 0;
				} else if (diff != 0) {
					map[i + diff][j] = map[i][j];
					map[i][j] = m + 1;
				}
			}
		}
	}

	public static void resetRainbow() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					v[i][j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		v = new boolean[n][n];
		selected = new boolean[n][n];
		boolean[][] maxSelected = new boolean[n][n];

		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		int rainbowMax = 0;
		int max = 0;
		int cnt;
		while (true) {
			max = 0;
			rainbowMax = 0;

			for (int k = 0; k < n; k++) {
				Arrays.fill(v[k], false);
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					
					resetRainbow();
					if (map[i][j] == -1 || map[i][j] == m + 1 || map[i][j] == 0 || v[i][j])
						continue;
					
					for (int k = 0; k < n; k++) {
						Arrays.fill(selected[k], false);
					}
					
					cnt = bfs(i, j);

					if (cnt < max || cnt == max && (rainbow < rainbowMax))
						continue;
					
					max = cnt;
					
					rainbowMax = rainbow;
					
					for (int k = 0; k < n; k++) {
						System.arraycopy(selected[k], 0, maxSelected[k], 0, n);
					}


				}
			}
			
			if (max < 2)
				break;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (maxSelected[i][j]) {
						map[i][j] = m + 1;
					}
				}
			}

			answer += max * max;

			gravity();

			rotate();

			gravity();
		}
        
		System.out.println(answer);
	}
}