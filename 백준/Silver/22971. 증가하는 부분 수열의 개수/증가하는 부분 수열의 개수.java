import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 998_244_353;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] A = new int[n];

		st = new StringTokenizer(br.readLine(), " ");
		int x;

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			A[i] = x;
		}

		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					dp[i] = (dp[i] + dp[j]) % MOD;
				}
			}
			sb.append(dp[i]).append(i == n - 1 ? "\n" : " ");
		}

		System.out.print(sb.toString());
	}
}