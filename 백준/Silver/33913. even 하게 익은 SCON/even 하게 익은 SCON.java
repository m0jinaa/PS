import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int MOD = 1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		long[][] dp = new long[n + 1][2];

		dp[0][0] = 1;

		for (int i = 1; i <= n; i++) {

			// 전체 길이가 n인 문자열 중에 n과 c의 총 개수가 짝수로 들어있는 문자열의 개수
			// = 길이가 n-1이고 n과 c의 총 개수가 짝수인 문자열+(n과 c를 뺀 알파벳) 또는
			// 길이가 n-1이고 n과 c의 총 개수가 홀수인 문자열 + (n 또는 c)

			dp[i][0] = (dp[i - 1][0] * 24 + dp[i - 1][1] * 2) % MOD;

			// n과 c의 총 개수가 홀수인 경우도 위와 유사한 방식으로 구한다.

			dp[i][1] = (dp[i - 1][1] * 24 + dp[i - 1][0] * 2) % MOD;
		}

		System.out.println(dp[n][0]);
	}
}