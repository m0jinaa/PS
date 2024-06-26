import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Diamond {
		double w, c;

		public Diamond(double w, double c) {
			super();
			this.w = w;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int n;

		Diamond[] diamonds;
		double w, c;

		int[] dp;
		int max;
		while (tc-- > 0) {

			n = Integer.parseInt(br.readLine());

			dp = new int[n + 1];

			diamonds = new Diamond[n + 1];

			diamonds[0] = new Diamond(-1, 101);

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				w = Double.parseDouble(st.nextToken());
				c = Double.parseDouble(st.nextToken());

				diamonds[i] = new Diamond(w, c);
			}

			max = 0;

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < i; j++) {
					if (diamonds[j].w < diamonds[i].w && diamonds[j].c > diamonds[i].c)
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				max = Math.max(max, dp[i]);
			}
			sb.append(max).append("\n");
		}

		System.out.print(sb.toString());
	}
}