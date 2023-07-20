import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Time implements Comparable<Time> {
		int h, m, s;

		public Time(int h, int m, int s) {
			super();
			this.h = h;
			this.m = m;
			this.s = s;
		}

		@Override
		public int compareTo(Time t) {
			if (this.h != t.h) {
				return this.h - t.h;
			} else if (this.m != t.m) {
				return this.m - t.m;
			} else {
				return this.s - t.s;
			}
		}

		@Override
		public String toString() {
			return h + " " + m + " " + s + "\n";
		};

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Time[] times = new Time[n];

		int h, m, s;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			h = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			times[i] = new Time(h, m, s);
		}

		Arrays.sort(times);

		for (Time t : times) {
			sb.append(t.toString());
		}

		System.out.println(sb.toString());
	}
}