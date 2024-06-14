import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long[][] dp = new long[21][211];

		dp[0][0] = 1;

		int limit;
		for (int i = 0; i < 20; i++) {
			limit = i * (i + 1) / 2;

			for (int j = 0; j <= limit; j++) {
				for (int l = 0; l <= i + 1; l++) {
					dp[i + 1][j + l] += dp[i][j];
				}
			}
		}

		int tc = Integer.parseInt(br.readLine());
		
		int n, k;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			k = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			sb.append(dp[k][n]).append("\n");
		}

		System.out.println(sb.toString());
	}
}