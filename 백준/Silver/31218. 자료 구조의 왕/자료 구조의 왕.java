import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[][] noLawn;

	static boolean inRange(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > m)
			return false;
		return true;
	}

	static int mow(int x, int y, int dx, int dy) {
		int c = 0;

		while (inRange(x, y) && !noLawn[x][y]) {
			noLawn[x][y] = true;
			c++;
			x += dx;
			y += dy;
		}

		return c;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		noLawn = new boolean[n + 1][m + 1];

		int lawn = n * m;

		int o, x, y, dx, dy;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());

			switch (o) {
			case 1:
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				lawn -= mow(x, y, dx, dy);
				break;
			case 2:
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				sb.append(noLawn[x][y] ? 1 : 0).append("\n");
				break;
			case 3:
				sb.append(lawn).append("\n");
				break;
			}
		}

		System.out.print(sb.toString());
	}
}