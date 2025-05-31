import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Interval implements Comparable<Interval> {
		int s, e, c;

		public Interval(int s, int e, int c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Interval i) {
			if (this.s != i.s) {
				return this.s - i.s;
			} else {
				return this.e - i.e;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		Interval[] intervals = new Interval[m + 1];

		int s, e, c;

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			intervals[i] = new Interval(s, e, c);
		}

		intervals[0] = new Interval(-100, -90, 0);

		Arrays.sort(intervals);

		int[] dp = new int[m + 1];

		int answer = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < i; j++) {
				if (intervals[j].e + r <= intervals[i].s) {
					dp[i] = Math.max(dp[i], dp[j] + intervals[i].c);
				}
			}

			answer = Math.max(dp[i], answer);
		}

		System.out.println(answer);
	}
}