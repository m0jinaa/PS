import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n, t, s;
	static Market[] markets;
	static int[][] dp;

	static class Market {
		int a, b;

		public Market(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

	}

	static int getMax() {
		int ind = 0;

		for (Market m : markets) {
			for (int i = 0; i <= t; i++) {
				if (i - m.b < 0)
					dp[ind][i] = dp[1 - ind][i];
				else if (i > s && i - m.b < s) {
					dp[ind][i] = Math.max(dp[ind][i - 1], dp[1 - ind][i]);
				} else {
					dp[ind][i] = Math.max(dp[1 - ind][i], Math.max(dp[ind][i - 1], dp[1 - ind][i - m.b] + m.a));
				}
			}
			ind = 1 - ind;
		}

		return dp[1 - ind][t];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		markets = new Market[n];

		int a, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			markets[i] = new Market(a, b);
		}

		dp = new int[2][t + 1];

		int answer = getMax();

		System.out.println(answer);

	}
}