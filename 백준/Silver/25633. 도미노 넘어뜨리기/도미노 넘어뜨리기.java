import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] A = new int[n + 1];

		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		dp[1][0] = A[1];

		for (int i = 2; i <= n; i++) {
			if (dp[i - 1][0] >= A[i])
				dp[i][0] = dp[i - 1][0] + A[i];
			dp[i][i - 1] = Math.max(A[i], dp[i - 1][i - 2]);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = i + 2; j <= n; j++) {
				if (dp[j - 1][i] >= A[j])
					dp[j][i] = dp[j - 1][i] + A[j];
				else
					dp[j][i] = dp[j - 1][i - 1];
			}
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			if (dp[n][i] == 0)
				continue;
			answer = n - i;
			break;
		}

		System.out.println(answer);
	}
}