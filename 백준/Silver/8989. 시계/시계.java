import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Clock implements Comparable<Clock> {
		int h, m, d;
		String s;

		public Clock(int h, int m, String s) {
			super();
			this.h = h;
			this.m = m;
			this.s = s;

			int degree = Math.abs(m * 12 - ((h % 12) * 5 * 12 + m));

			this.d = Math.min(degree, 720 - degree);
		}

		@Override
		public int compareTo(Clock c) {
			if (this.d != c.d)
				return this.d - c.d;
			else if (this.h != c.h)
				return this.h - c.h;
			else {
				return this.m - c.m;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st, stt;

		int t = Integer.parseInt(br.readLine());
		final int n = 5;

		Clock[] clocks = new Clock[n];

		int h, m;
		String s;

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < n; i++) {
				s = st.nextToken();
				stt = new StringTokenizer(s, ":");

				h = Integer.parseInt(stt.nextToken());
				m = Integer.parseInt(stt.nextToken());

				clocks[i] = new Clock(h, m, s);

			}

			Arrays.sort(clocks);

			sb.append(clocks[2].s).append("\n");
		}

		System.out.print(sb.toString());
	}
}