import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Interval implements Comparable<Interval> {
		int s, e;

		public Interval(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Interval interval) {
			if (this.e - this.s < interval.e - interval.s) {
				return -1;
			} else if (this.e - this.s > interval.e - interval.s) {
				return 1;
			} else {
				return this.s - interval.s;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Interval[] intervals = new Interval[n];

		int s, e;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			intervals[i] = new Interval(s, e);
		}

		Arrays.sort(intervals);

		int answer = 0;

		int c;

		for (int i = 1; i < n; i++) {
			c = 0;
			for (int j = 0; j < i; j++) {
				if (intervals[i].s < intervals[j].s && intervals[j].e < intervals[i].e)
					c++;
			}

			answer = Math.max(answer, c);
		}

		System.out.println(answer);
	}
}