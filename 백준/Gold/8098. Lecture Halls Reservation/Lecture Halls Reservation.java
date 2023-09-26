import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dp;
	static Lecture[] lectures;

	static class Lecture implements Comparable<Lecture> {
		int s, e;

		public Lecture(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Lecture l) {
			if (this.e != l.e)
				return this.e - l.e;
			else
				return this.s - l.s;
		}
	}

	static int getMax() {
		int ind = 0;

		for (int i = 1; i < 30001; i++) {
			while (ind < n && lectures[ind].e == i) {
				dp[i] = Math.max(dp[i], dp[lectures[ind].s] + lectures[ind].e - lectures[ind].s);
				ind++;
			}
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}

		return dp[30000];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		lectures = new Lecture[n];
		dp = new int[30001];
		int s, e;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			lectures[i] = new Lecture(s, e);
		}

		Arrays.sort(lectures);

		int answer = getMax();

		System.out.println(answer);

	}
}