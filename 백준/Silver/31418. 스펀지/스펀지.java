import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int MOD = 998_244_353;

		long answer = 1;

		st = new StringTokenizer(br.readLine(), " ");

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int x, y, sx, sy, ex, ey, r, c;

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			sx = Math.max(1, x - t);
			sy = Math.max(1, y - t);

			ex = Math.min(w, x + t);
			ey = Math.min(h, y + t);

			r = ex - sx + 1;
			c = ey - sy + 1;

			answer = (answer * ((1L * r * c) % MOD)) % MOD;
		}

		System.out.println(answer);
	}
}
