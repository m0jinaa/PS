import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Pollution implements Comparable<Pollution> {
		long x, p;

		public Pollution(long x, long p) {
			super();
			this.x = x;
			this.p = p;
		}

		@Override
		public int compareTo(Pollution pollution) {
			if (this.x < pollution.x)
				return -1;
			else if (this.x > pollution.x)
				return 1;
			else
				return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Pollution[] pollutions = new Pollution[n];

		int x;
		long p;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			p = Long.parseLong(st.nextToken());

			pollutions[i] = new Pollution(x, p);
		}

		Arrays.sort(pollutions);

		// 왼->오
		long left = 0;

		long bef = pollutions[0].x;

		for (int i = 0; i < n; i++) {
			left += pollutions[i].p;
			left += (pollutions[i].x - bef) * i;
			bef = pollutions[i].x;
		}

		// 오->왼
		long right = 0;

		bef = pollutions[n - 1].x;

		for (int i = n - 1; i >= 0; i--) {
			right += pollutions[i].p;
			right += (bef - pollutions[i].x) * (n - 1 - i);
			bef = pollutions[i].x;
		}

		final long INF = Long.MAX_VALUE;

		long answer = INF;

		long min;
		long l, r;

		l = left - pollutions[0].p - (pollutions[n - 1].x - pollutions[0].x);
		r = right - pollutions[0].p - (pollutions[1].x - pollutions[0].x) * (n - 1);

		min = Math.min(l, r);
		answer = Math.min(answer, min);

		for (int i = 1; i < n - 1; i++) {
			l = left - pollutions[i].p - (pollutions[n - 1].x - pollutions[i].x);
			r = right - pollutions[i].p - (pollutions[i].x - pollutions[0].x);

			min = Math.min(l, r);

			answer = Math.min(answer, min);
		}

		l = left - pollutions[n - 1].p - (pollutions[n - 1].x - pollutions[n - 2].x) * (n - 1);
		r = right - pollutions[n - 1].p - (pollutions[n - 1].x - pollutions[0].x);

		min = Math.min(l, r);
		answer = Math.min(answer, min);

		System.out.println(answer);

	}
}