import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] dx = new int[] { 0, 1, 1, 1 };
		int[] dy = new int[] { 1, 0, 1, -1 };

		int tc = Integer.parseInt(br.readLine());

		int n, k, ind;
		char[][] input;
		char[][] map;
		boolean blue, red, possible;

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			input = new char[n][];
			map = new char[n][n];

			for (int i = 0; i < n; i++) {
				input[i] = br.readLine().toCharArray();
			}

			// gravity

			for (int j = 0; j < n; j++) {
				ind = n - 1;
				for (int i = n - 1; i >= 0; i--) {
					if (input[n - 1 - j][i] != '.') {
						map[ind][j] = input[n - 1 - j][i];
						ind--;
					}
				}

				while (ind >= 0) {
					map[ind--][j] = '.';
				}
			}

			// check if they can make k in a row
			blue = false;
			red = false;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '.' || (blue && map[i][j] == 'B') || (red && map[i][j] == 'R'))
						continue;

					// 4방향 다 체크 해 볼 것
					for (int h = 0; h < 4; h++) {
						// k만큼의 길이가 나올 수 있는 거리 확보가 되어있나 확인
						if (dx[h] == 1 && i + k - 1 >= n) {
							continue;
						}

						if (dy[h] == 1 && j + k - 1 >= n) {
							continue;
						} else if (dy[h] == -1 && j - k + 1 < 0) {
							continue;
						}

						possible = true;

						for (int w = 1; w < k; w++) {
							if (map[i + dx[h] * w][j + dy[h] * w] != map[i][j]) {
								possible = false;
								break;
							}
						}

						if (possible) {
							if (map[i][j] == 'B') {
								blue = true;
							} else {
								red = true;
							}
							break;
						}
					}
				}
			}

			sb.append("Case #").append(t).append(": ");

			if (blue && red) {
				sb.append("Both\n");
			} else if (blue) {
				sb.append("Blue\n");
			} else if (red) {
				sb.append("Red\n");
			} else {
				sb.append("Neither\n");
			}
		}

		System.out.print(sb.toString());
	}
}