import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, total;

	static class Tire {
		int s, p;

		public Tire(int s, int p) {
			super();
			this.s = s;
			this.p = p;
		}
	}

	static Tire[] tires;
	static long[] dp;

	static char getMax() {

		for (Tire t : tires) {
			for (int j = m; j >= t.p; j--) {

				dp[j] = Math.max(dp[j], dp[j - t.p] + t.s);

				if (j >= t.p + 1)
					dp[j] = Math.max(dp[j], dp[j - (t.p + 1)] + t.s * 2);
			}
		}

		long max = 0;
		for (int i = m; i >= 0; i--) {
			max = Math.max(max, dp[i]);
		}

		char answer = 'L';

		if (max > total)
			answer = 'W';
		else if (max == total)
			answer = 'D';

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dp = new long[m + 1]; // dp[i] = i명 배치했을 때 얻을 수 있는 최대 점수

		int s, p;

		tires = new Tire[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());

			tires[i] = new Tire(s, p);

			total += s;
		}

		System.out.println(getMax());
	}
}