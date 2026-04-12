import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= n);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		char[][] map = new char[n][];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int nx, ny;
		int c;

		boolean correct = true;

		end: for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ('0' <= map[i][j] && map[i][j] <= '4') {
					c = 0;
					for (int k = 0; k < 4; k++) {
						nx = i + dx[k];
						ny = j + dy[k];

						if (!inRange(nx, ny) || map[nx][ny] != '?')
							continue;

						c++;
					}

					if (c != map[i][j] - '0') {
						correct = false;
						break end;
					}
				} else if (map[i][j] == '?') {
					// 왼쪽 방향 불 켜기
					nx = i - 1;
					ny = j;
					while (nx >= 0 && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
						map[nx][ny] = '@';
						nx--;
					}

					if (nx >= 0 && map[nx][ny] == '?') {
						correct = false;
						break end;
					}

					// 오른쪽 방향 불 켜기
					nx = i + 1;
					ny = j;
					while (nx < n && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
						map[nx][ny] = '@';
						nx++;
					}

					if (nx < n && map[nx][ny] == '?') {
						correct = false;
						break end;
					}

					// 윗 방향 불 켜기
					nx = i;
					ny = j - 1;
					while (ny >= 0 && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
						map[nx][ny] = '@';
						ny--;
					}

					if (ny >= 0 && map[nx][ny] == '?') {
						correct = false;
						break end;
					}

					// 아래 방향 불 켜기
					nx = i;
					ny = j + 1;
					while (ny < n && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
						map[nx][ny] = '@';
						ny++;
					}

					if (ny < n && map[nx][ny] == '?') {
						correct = false;
						break end;
					}
				}
			}
		}

		// 모든 빈칸에 불빛이 닿는지 확인
		end: for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '.') {
					correct = false;
					break end;
				}
			}
		}

		System.out.println(correct ? 1 : 0);
	}
}