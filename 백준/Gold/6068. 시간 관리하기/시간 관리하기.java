import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Work implements Comparable<Work> {
		int t, s;

		public Work(int t, int s) {
			super();
			this.t = t;
			this.s = s;
		}

		public int compareTo(Work w) {
			return this.s == w.s ? (w.t - this.t) : (w.s - this.s);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Work[] works = new Work[n];

		int t, s;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			t = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			works[i] = new Work(t, s);
		}

		Arrays.sort(works);

		final int INF = 1_000_001;

		int answer = INF;

		for (Work w : works) {
			answer = Math.min(answer, w.s);
			answer -= w.t;
		}

		System.out.println(answer < 0 ? -1 : answer);
	}
}