import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, a, d;
	static int[] s;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		s = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}

		final int INF = 10001;

		st = new StringTokenizer(br.readLine(), " ");

		a = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		dp = new int[n + d][n + 1];
		int answer = INF;

		for (int i = 1; i < n + d; i++) {
			for (int j = 0; j <= n; j++) {

				dp[i][j] = Math.max(dp[i - 1][j] + (i <= n ? s[i] : 0), dp[i][j]);

				if (i >= d && j >= 1)
					dp[i][j] = Math.max(dp[i][j], dp[i - d][j - 1] + a);

				if (dp[i][j] >= m)
					answer = Math.min(answer, j);
			}
		}

		System.out.println(answer == INF ? -1 : answer);
	}
}