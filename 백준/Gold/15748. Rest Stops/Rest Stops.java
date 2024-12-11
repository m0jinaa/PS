import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Stop implements Comparable<Stop> {
		int x, c;

		public Stop(int x, int c) {
			super();
			this.x = x;
			this.c = c;
		}

		public int compareTo(Stop s) {
			return this.c == s.c ? this.x - s.x : s.c - this.c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int l = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		long john = Long.parseLong(st.nextToken());
		long bessie = Long.parseLong(st.nextToken());

		Stop[] stops = new Stop[n];

		int x, c;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			stops[i] = new Stop(x, c);
		}

		Arrays.sort(stops);

		int bef = 0;

		long answer = 0;

		for (Stop s : stops) {
			if (s.x <= bef)
				continue;
			answer += (s.x - bef) * (john - bessie) * s.c;

			bef = s.x;
		}

		System.out.println(answer);

	}
}