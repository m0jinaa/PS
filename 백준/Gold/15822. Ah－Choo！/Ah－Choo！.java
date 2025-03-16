import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final long INF = Long.MAX_VALUE;

		int n = Integer.parseInt(br.readLine());

		long[] A = new long[n + 1];
		long[] B = new long[n + 1];
		long[][] dp = new long[n + 1][n + 1];

		// A 입력 받기

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());

			// dp 초기화
			dp[i][0] = INF;
			dp[0][i] = INF;
		}

		// B 입력 받기

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		// dp[i][j] = A[i]와 B[j]를 연결 할 때까지의 최소값
		// = dp[i-1][j],dp[i][j-1],dp[i-1][j-1] 중 최소값 + (A[i]-B[j])^2

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]))
						+ (A[i] - B[j]) * (A[i] - B[j]);
			}
		}

		System.out.println(dp[n][n]);
	}
}