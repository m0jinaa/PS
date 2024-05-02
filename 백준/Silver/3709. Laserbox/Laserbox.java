import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int n;
	static boolean[][] gadget;
	static boolean[][][] v;

	static int[] dx = new int[] { 0, 1, 0, -1 };
	static int[] dy = new int[] { 1, 0, -1, 0 };

	static boolean inRange(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > n)
			return false;
		return true;
	}

	static void laserMove(int x, int y, int d) {

		int ex = -1, ey = -1;

		while (true) {
			x += dx[d];
			y += dy[d];
			if (!inRange(x, y)) {
				ex = x;
				ey = y;
				break;
			} else if (v[x][y][d]) {
				ex = 0;
				ey = 0;
			}

			v[x][y][d] = true;

			if (gadget[x][y])
				d = (d + 1) % 4;
		}

		sb.append(ex).append(" ").append(ey).append("\n");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		int m, a, b, sx, sy, dir;

		while (tc-- > 0) {

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			gadget = new boolean[n + 1][n + 1];
			v = new boolean[n + 1][n + 1][4];

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");

				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				gadget[a][b] = true;
			}

			st = new StringTokenizer(br.readLine(), " ");

			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());

			if (sx == 0)
				dir = 1;
			else if (sy == 0)
				dir = 0;
			else if (sx == n + 1)
				dir = 3;
			else
				dir = 2;

			laserMove(sx, sy, dir);
		}

		System.out.print(sb.toString());
	}
}