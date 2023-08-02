import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int h, w, n, sx, sy, ex, ey;
	static char[][] map;
	static int[][] move;
	static boolean[][] v;
	static int[] selected;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= h || y < 0 || y >= w)
			return false;
		return true;
	}

	static boolean check() {
		int x = sx;
		int y = sy;
		boolean arrive = false;
		int last = 0;
		for (int i = 0; i < n; i++) {
			x += dx[selected[i]];
			y += dy[selected[i]];

			if (!inRange(x, y) || map[x][y] != '.')
				break;
			else if (x == ex && y == ey) {
				arrive = true;
				last = i;
				break;
			}

		}

		if (arrive) {
			sb.append("YES\n");
			for (int i = 0; i <= last; i++) {
				switch (selected[i]) {
				case 0:
					sb.append('D');
					break;
				case 1:
					sb.append('A');
					break;
				case 2:
					sb.append('S');
					break;
				case 3:
					sb.append('W');
					break;
				}
			}
		}

		return arrive;
	}

	static boolean combi(int ind) {
		if (ind == n) {
			return check();
		} else {
			for (int i = 0; i < 2; i++) {
				selected[ind] = move[ind][i];
				if (combi(ind + 1))
					return true;
			}
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		sb = new StringBuilder();

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		map = new char[h][];

		for (int i = 0; i < h; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 'D') {
					sx = i;
					sy = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'Z') {
					ex = i;
					ey = j;
					map[i][j] = '.';
				}
			}
		}
		n = Integer.parseInt(br.readLine());

		move = new int[n][2];
		selected = new int[n];

		char x;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				x = st.nextToken().charAt(0);
				switch (x) {
				case 'W':
					move[i][j] = 3;
					break;
				case 'A':
					move[i][j] = 1;
					break;
				case 'S':
					move[i][j] = 2;
					break;
				case 'D':
					move[i][j] = 0;
					break;
				}
			}
		}

		if (!combi(0))
			sb.append("NO");

		System.out.println(sb.toString());
	}
}