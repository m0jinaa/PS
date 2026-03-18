import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int h, w;
	static char[][] map;
	static int[][][] v;
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static char[] dir = new char[] { 'N', 'E', 'S', 'W' };

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= h || y < 0 || y >= w);
	}

	static String move(int x, int y, int d, long l) {

		v[x][y][d] = 0;

		long loc = l;
		int t = 0;

		int nx, ny;

		while (t < l) {
			t++;

			nx = x + dx[d];
			ny = y + dy[d];

			while (!inRange(nx, ny) || map[nx][ny] == '#') {
				d = (d + 1) % 4;
				nx = x + dx[d];
				ny = y + dy[d];
			}

			if (v[nx][ny][d] == -1) {
				v[nx][ny][d] = t;
			} else {
				loc = v[nx][ny][d] + ((l - v[nx][ny][d]) % (t - v[nx][ny][d]));
				break;
			}

			x = nx;
			y = ny;
		}

		// 로봇 마지막 위치 찾기
		String ret = "";

		end: for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				for (int k = 0; k < 4; k++) {
					if (v[i][j][k] == loc) {
						ret = (i + 1) + " " + (j + 1) + " " + dir[k];
						break end;
					}
				}
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long l;
		int sx = -1, sy = -1, sd = -1;

		while (true) {
			// 맵 사이즈 및 이동 거리
			st = new StringTokenizer(br.readLine(), " ");

			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			l = Long.parseLong(st.nextToken());

			if (h == 0 && w == 0 && l == 0)
				break;

			// 맵
			map = new char[h][];
			v = new int[h][w][4];

			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					Arrays.fill(v[i][j], -1);

					if (map[i][j] == '#' || map[i][j] == '.') {
						continue;
					}

					sx = i;
					sy = j;

					switch (map[i][j]) {
					case 'N':
						sd = 0;
						break;
					case 'E':
						sd = 1;
						break;
					case 'S':
						sd = 2;
						break;
					default:
						sd = 3;
						break;
					}
				}
			}

			sb.append(move(sx, sy, sd, l)).append("\n");
		}

		System.out.print(sb.toString());
	}
}