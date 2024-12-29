import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Monitor implements Comparable<Monitor> {
		int w, h, ind;

		public Monitor(int w, int h, int ind) {
			super();
			this.w = w;
			this.h = h;
			this.ind = ind;
		}

		int getPPL() {
			return this.w * this.w + this.h * this.h;
		}

		@Override
		public int compareTo(Monitor m) {
			return m.getPPL() - this.getPPL();
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Monitor[] monitors = new Monitor[n];

		int w, h;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			monitors[i] = new Monitor(w, h, i + 1);
		}

		Arrays.sort(monitors);

		for (Monitor m : monitors) {
			sb.append(m.ind).append("\n");
		}

		System.out.print(sb.toString());
	}
}