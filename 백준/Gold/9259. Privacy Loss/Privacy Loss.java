import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, B, P;
	static int[][] dp;
	static Option[] options;

	static class Option {
		int s, c, p;

		public Option(int s, int c, int p) {
			super();
			this.s = s;
			this.c = c;
			this.p = p;
		}
	}

	static int getMax() {

		for (Option o : options) {

			for (int i = B; i >= o.c; i--) {
				for (int j = P; j >= o.p; j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i - o.c][j - o.p] + o.s);
				}
			}
		}

		return dp[B][P];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int k = Integer.parseInt(br.readLine());
		int s, c, p, answer;
		for (int t = 1; t <= k; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());

			dp = new int[B + 1][P + 1];

			options = new Option[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				s = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());

				options[i] = new Option(s, c, p);
			}

			answer = getMax();
			if (t != 1)
				sb.append("\n");
			sb.append("Data Set ").append(t).append(":\n").append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}