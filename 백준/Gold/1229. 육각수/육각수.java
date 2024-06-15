import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[1000001];

		int[] cnt = new int[709];

		for (int i = 1; i <= 708; i++) {
			cnt[i] = 2 * i * i - i;
		}

		Arrays.fill(dp, -1);

		dp[0] = 0;
		dp[1] = 1;

		int c;

		for (int i = 2; i <= n; i++) {
			c = i;

			for (int j = 1; cnt[j] <= i && c>2; j++) {
				c = Math.min(c, dp[i - cnt[j]] + 1);
			}

			dp[i] = c;
		}

		System.out.println(dp[n]);
	}
}