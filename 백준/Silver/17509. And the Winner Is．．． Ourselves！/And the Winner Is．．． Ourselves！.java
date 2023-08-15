import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Time implements Comparable<Time> {
		int t, v;

		public Time(int t, int v) {
			super();
			this.t = t;
			this.v = v;
		}

		@Override
		public int compareTo(Time time) {
			return this.t - time.t;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = 11;

		int t, v;
		int answer = 0;

		Time[] times = new Time[11];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			t = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			times[i] = new Time(t, v);
		}

		Arrays.sort(times);
		int now = 0;

		for (Time time : times) {
			now += time.t;
			answer += now + time.v * 20;
		}

		System.out.println(answer);
	}
}