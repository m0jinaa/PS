import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

	static class Tire {
		int s, p;

		public Tire(int s, int p) {
			super();
			this.s = s;
			this.p = p;
		}
	}

	static Tire[] tires;
	static int[] dp;
	static final int INF = 1_000_000_007;

	static char getMax() {

		int diff = dp[0];

		for (Tire t : tires) {
			for (int j = m; j >= t.p; j--) {
				if (dp[j - t.p] == INF)
					continue;
				dp[j] = Math.min(dp[j], dp[j - t.p] - t.s);
			}
		}

		for (int i = m; i >= 0; i--) {
			diff = Math.min(diff, dp[i]);
		}

		char answer = 'L';
		if (diff < 0)
			answer = 'W';
		else if (diff == 0)
			answer = 'D';

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dp = new int[m + 1];

		int s, p;

		int total = 0;
		tires = new Tire[2 * n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());

			tires[2 * i] = new Tire(s, p);
			tires[2 * i + 1] = new Tire(s * 2, p + 1);

			total += s;
		}

		Arrays.fill(dp, INF);

		dp[0] = total;

		System.out.println(getMax());

	}
}