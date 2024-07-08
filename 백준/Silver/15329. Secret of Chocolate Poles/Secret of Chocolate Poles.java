import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int l = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long answer = 0;

		long[] dp = new long[l + 1];

		dp[1] = 1L;

		if (k <= l)
			dp[k] = 1;
		for (int i = 1; i <= l; i++) {
			if (i - 1 == 0) {
				dp[i] += dp[i - 1];
			} else {
				dp[i] += dp[i - 2];
			}

			if (k <= i) {
				if (i - k == 0) {
					dp[i] += dp[i - k];
				} else {
					dp[i] += dp[i - k - 1];
				}
			}

			answer += dp[i];
		}

		System.out.println(answer);
	}
}