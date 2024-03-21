import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		boolean[][] dp = new boolean[n + 1][7];

		dp[0][0] = true;
		int x;
		int nx;

		st = new StringTokenizer(br.readLine(), " ");

		boolean answer = false;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());

			for (int j = 6; j >= 0; j--) {
				if (!dp[i - 1][j])
					continue;
				dp[i][j] = dp[i - 1][j];
				nx = (x + j) % 7;
				dp[i][nx] = true;
			}
			answer |= dp[i][4];
		}

		System.out.println(answer ? "YES" : "NO");
	}
}