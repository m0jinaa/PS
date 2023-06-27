import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Dot implements Comparable<Dot> {
		long x, y;

		public Dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Dot d) {
			long tx, ty;
			tx = this.x - d.x;
			ty = this.y - d.y;
			if (tx == 0) {
				if (ty < 0)
					return -1;
				else if (ty == 0)
					return 0;
				else
					return 1;
			} else if (tx > 0)
				return 1;
			else
				return -1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Dot[] dots = new Dot[4];

		int tc = Integer.parseInt(br.readLine());

		int x, y;
		long l1, l2, l3, l4, c1, c2;
		while (tc-- > 0) {
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				dots[i] = new Dot(x, y);
			}

			Arrays.sort(dots);

			l1 = (long) Math.pow(dots[0].x - dots[1].x, 2) + (long) Math.pow(dots[0].y - dots[1].y, 2);
			l2 = (long) Math.pow(dots[0].x - dots[2].x, 2) + (long) Math.pow(dots[0].y - dots[2].y, 2);
			l3 = (long) Math.pow(dots[1].x - dots[3].x, 2) + (long) Math.pow(dots[1].y - dots[3].y, 2);
			l4 = (long) Math.pow(dots[2].x - dots[3].x, 2) + (long) Math.pow(dots[2].y - dots[3].y, 2);
			c1 = (long) Math.pow(dots[0].x - dots[3].x, 2) + (long) Math.pow(dots[0].y - dots[3].y, 2);
			c2 = (long) Math.pow(dots[2].x - dots[1].x, 2) + (long) Math.pow(dots[2].y - dots[1].y, 2);

			if (l1 == l2 && l2 == l3 && l3 == l4 && c1 == c2) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}