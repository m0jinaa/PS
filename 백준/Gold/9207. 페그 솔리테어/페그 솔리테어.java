import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, m;
	static char[][] map;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0, };

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= m);
	}

	static int getMaxCnt() {
		int cnt = 0;

		int nx, ny, nnx, nny;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 핀이 아니면 패스
				if (map[i][j] != 'o')
					continue;

				for (int k = 0; k < 4; k++) {
                    //근접한 칸
					nx = i + dx[k];
					ny = j + dy[k];
                    
                    //그 방향으로 다음 칸
					nnx = nx + dx[k];
					nny = ny + dy[k];

					// 근접한 칸이 존재하지 않거나, 근접한 칸이 핀이 아니거나, 그 다음칸이 존재하지 않거나, 그 다음칸이 빈칸이 아닌 경우
					if (!inRange(nx, ny) || map[nx][ny] != 'o' || !inRange(nnx, nny) || map[nnx][nny] != '.')
						continue;

					// 핀 이동시키고 근접한 핀 제거
					map[i][j] = '.';
					map[nx][ny] = '.';
					map[nnx][nny] = 'o';

					cnt = Math.max(cnt, 1 + getMaxCnt());
                    
                    //원상복구
					map[nnx][nny] = '.';
					map[nx][ny] = 'o';
					map[i][j] = 'o';
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		n = 5;
		m = 9;

		map = new char[n][];

		int answer, removed;
		int pin;

		while (tc-- > 0) {
			pin = 0;

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 'o')
						pin++;
				}
			}
			removed = getMaxCnt();

			answer = pin - removed;

			sb.append(answer).append(" ").append(removed).append("\n");

			if (tc > 0) {
				br.readLine();
			}
		}

		System.out.print(sb.toString());
	}
}