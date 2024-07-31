import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int r, c;
		long[][] dp = new long[26][26];

		dp[0][1] = 1;

		for (int i = 1; i < 26; i++) {
			for (int j = 1; j < 26; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			sb.append("Case #").append(t).append(": ").append(dp[r][c]).append("\n");
		}

		System.out.print(sb.toString());
	}
}