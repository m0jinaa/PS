import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[n][2];

		int[][] ab = new int[n][2];

		int a, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			ab[i][0] = a;
			ab[i][1] = b;
		}

		dp[0][0] = ab[0][0];
		dp[0][1] = ab[0][1];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Math.abs(ab[i - 1][1 - k] - ab[i][1 - j]) + ab[i][j]);
				}
			}
		}

		int answer = Math.max(dp[n - 1][0], dp[n - 1][1]);

		System.out.println(answer);
	}
}