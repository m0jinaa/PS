import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Score implements Comparable<Score> {
		int x, c, last;

		public Score(int x, int c, int last) {
			super();
			this.x = x;
			this.c = c;
			this.last = last;
		}

		@Override
		public int compareTo(Score s) {
			return s.x - this.x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()) * 24;
		int m = Integer.parseInt(st.nextToken());

		int[] A = new int[m];
		int[] B = new int[m];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < m; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		PriorityQueue<Score> q = new PriorityQueue<>();

		int x, c, last;

		int answer = 0;

		for (int i = 0; i < m; i++) {
			answer += A[i];
			x = B[i];
			c = (int) Math.ceil(1.0 * (100 - A[i]) / B[i]);
			last = ((100 - A[i]) % B[i]);

			if (last == 0)
				last = x;

			q.add(new Score(x, c, last));
		}

		Score s;

		while (!q.isEmpty()) {
			s = q.poll();
			if (s.c <= n) {
				if (s.last != 0) {
					n -= (s.c - 1);
					answer += s.x * (s.c - 1);
					q.add(new Score(s.last, 1, 0));
				} else {
					n -= s.c;
					answer += s.x * s.c;
				}
			} else {
				answer += n * s.x;
				break;
			}
		}

		System.out.println(answer);
	}
}