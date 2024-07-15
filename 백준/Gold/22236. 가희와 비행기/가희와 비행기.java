import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int d = Integer.parseInt(st.nextToken());
		final int m = Integer.parseInt(st.nextToken());

		long[][] dp = new long[d + 1][d + 1];

		dp[1][1] = 1;
		for (int i = 2; i < d; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0)
					continue;
				else
					dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] + dp[i - 1][j + 1]) % m;
			}
		}

		System.out.println(dp[d - 1][1] % m);
	}
}