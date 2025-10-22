import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final String UP = "Up";
		final String STAY = "Stay";
		final String DOWN = "Down";

		// 순서대로 상, 좌, 하, 우 이동
		int[] dx = new int[] { -1, 0, 1, 0 };
		int[] dy = new int[] { 0, -1, 0, 1 };

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][n];

		char[] row;

		int x = -1, y = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					x = i;
					y = j;
					map[i][j] = 0;
				}
			}
		}

		String[] keys = new String[4];

		for (int i = 0; i < 4; i++) {
			keys[i] = br.readLine();
		}

		row = br.readLine().toCharArray();

		int[] pushed = new int[m];

		for (int i = 0; i < m; i++) {
			switch (row[i]) {
			case 'W':
				pushed[i] = 0;
				break;
			case 'A':
				pushed[i] = 1;
				break;
			case 'S':
				pushed[i] = 2;
				break;
			case 'D':
				pushed[i] = 3;
				break;
			}
		}

		int nx, ny;

		// 프레임마다 확인
		for (int i = 0; i < m; i++) {
			// w,a,s,d 순으로 확인
			for (int j = 0; j < 4; j++) {
				// down, up 확인
				if (i == 0 || pushed[i] != pushed[i - 1]) {
					// 키 일치 확인
					if (pushed[i] == j && DOWN.equals(keys[j])) {
						nx = x + dx[j];
						ny = y + dy[j];

						// 격자 벗어나는지 또는 벽인지 확인
						if (!(nx < 0 || nx >= n || ny < 0 || ny >= n) && map[nx][ny] != 1) {
							x = nx;
							y = ny;
						}
					}

					// 키 일치 확인
					if (i != 0 && pushed[i - 1] == j && UP.equals(keys[j])) {
						nx = x + dx[j];
						ny = y + dy[j];

						// 격자 벗어나는지 또는 벽인지 확인
						if (!(nx < 0 || nx >= n || ny < 0 || ny >= n) && map[nx][ny] != 1) {
							x = nx;
							y = ny;
						}
					}
				} else if (pushed[i] == pushed[i - 1]) { // stay 확인
					// 키 일치 확인
					if (pushed[i] == j && STAY.equals(keys[j])) {
						nx = x + dx[j];
						ny = y + dy[j];

						// 격자 벗어나는지 또는 벽인지 확인
						if (!(nx < 0 || nx >= n || ny < 0 || ny >= n) && map[nx][ny] != 1) {
							x = nx;
							y = ny;
						}
					}
				}

			}

		}

		sb.append(x + 1).append(" ").append(y + 1).append("\n");

		System.out.println(sb.toString());
	}
}