import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Homework implements Comparable<Homework> {
		int d, t;

		public Homework(int d, int t) {
			super();
			this.d = d;
			this.t = t;
		}

		@Override
		public int compareTo(Homework h) {
			if (this.t != h.t)
				return h.t - this.t;
			else
				return h.d - this.t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Homework[] hws = new Homework[n];

		int d, t;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			hws[i] = new Homework(d, t);
		}

		Arrays.sort(hws);

		int last = 1_000_000_000;

		for (Homework h : hws) {
			last = Math.min(last, h.t);
			last -= h.d;
		}

		System.out.println(last);
	}
}