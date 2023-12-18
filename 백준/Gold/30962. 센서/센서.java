import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ccw(int x1, int y1, int x2, int y2) { // (0,0)기준
		int v = x1 * y2 - y1 * x2;

		if (v < 0)
			return -1;
		else if (v > 0)
			return 1;
		else
			return 0;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int q = Integer.parseInt(br.readLine());

		int x1, y1, x2, y2, w, y;
		int cnt = 0;
		int limit;
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			cnt = 0;
			limit = (int) Math.sqrt(w);

			for (int x = 1; x <= limit; x++) {
				y = (int) Math.sqrt(w - x * x);
				if (x * x + y * y != w)
					continue;
				if (ccw(x1, y1, x, y) * ccw(x2, y2, x, y) <= 0)
					cnt++;
			}
			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());
	}
}