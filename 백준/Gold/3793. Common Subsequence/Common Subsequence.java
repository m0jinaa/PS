import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static char[] s1, s2;

	public static int getMax() {
		int n = s1.length;
		int m = s2.length;

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1[i - 1] == s2[j - 1]) {
					dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i - 1][j], dp[i][j - 1]));
				} else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[n][m];

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		StringTokenizer st;
		while ((str = br.readLine()) != null && !str.isEmpty()) {
			st = new StringTokenizer(str, " \t\n");
			if (st.countTokens() == 2) {
				s1 = st.nextToken().toCharArray();
				s2 = st.nextToken().toCharArray();
			} else {
				s1 = st.nextToken().toCharArray();
				s2 = br.readLine().trim().toCharArray();
			}

			sb.append(getMax()).append("\n");

		}

		System.out.println(sb.toString());
	}
}