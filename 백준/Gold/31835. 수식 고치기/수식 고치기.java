import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int m = (n + 1) / 2;

		int[][] dp = new int[m][2];

		String v, o;

		// T & T = T
		// T & F = F
		// F & F = F

		// T | T = T
		// T | F = T
		// F | F = F
		for (int i = 0; i < m; i++) {

			if (i == 0) {
				v = st.nextToken();
				if ("T".equals(v)) {
					dp[0][1] = 0;
					dp[0][0] = 1;
				} else {
					dp[0][1] = 1;
					dp[0][0] = 0;
				}
			} else {
				o = st.nextToken();
				v = st.nextToken();

				if ("T".equals(v) && "&".equals(o)) {
					dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1] + 1);
					dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0] + 1);
				} else if ("T".equals(v) && "|".equals(o)) {
					dp[i][0] = Math.min(dp[i - 1][0] + 1, dp[i - 1][1] + 2);
					dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
				} else if ("F".equals(v) && "&".equals(o)) {
					dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
					dp[i][1] = Math.min(dp[i - 1][0] + 2, dp[i - 1][1] + 1);
				} else { // F and |
					dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1] + 1);
					dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0] + 1);
				}
			}
		}

		String c = br.readLine();

		System.out.println("T".equals(c) ? dp[m - 1][1] : dp[m - 1][0]);
	}
}