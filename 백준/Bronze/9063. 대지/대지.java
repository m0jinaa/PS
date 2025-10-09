import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int sx = 10001;
		int sy = 10001;
		int ex = -10001;
		int ey = -10001;

		int x, y;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			sx = Math.min(sx, x);
			sy = Math.min(sy, y);
			ex = Math.max(ex, x);
			ey = Math.max(ey, y);
		}

		int space = (ex - sx) * (ey - sy);

		System.out.println(space);
	}
}