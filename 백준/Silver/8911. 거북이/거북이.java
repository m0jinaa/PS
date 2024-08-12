import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		int[] dx = new int[] { -1, 0, 1, 0 };
		int[] dy = new int[] { 0, -1, 0, 1 };

		int d;

		int x, y;

		int sx, sy, ex, ey;
		int space;

		char[] row;
		while (tc-- > 0) {
			sx = 0;
			sy = 0;
			ex = 0;
			ey = 0;
			x = 0;
			y = 0;
			d = 0;

			row = br.readLine().toCharArray();

			for (char c : row) {
				switch (c) {
				case 'F':
					x += dx[d];
					y += dy[d];
					break;
				case 'B':
					x -= dx[d];
					y -= dy[d];
					break;
				case 'L':
					d = (d + 1) % 4;
					break;
				case 'R':
					d = (d + 3) % 4;
					break;
				}
				sx = Math.min(sx, x);
				sy = Math.min(sy, y);
				ex = Math.max(ex, x);
				ey = Math.max(ey, y);
			}

			space = (ex - sx) * (ey - sy);

			sb.append(space).append("\n");
		}

		System.out.print(sb.toString());
	}
}
