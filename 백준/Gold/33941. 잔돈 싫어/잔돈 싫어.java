import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int MOD = 50;

		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[2][MOD];

		Arrays.fill(dp[0], -1);
		Arrays.fill(dp[1], -1);

		dp[0][0] = 0;

		int a, x, p = 0;

		while (n-- > 0) {
			a = Integer.parseInt(br.readLine());

			// 잔액이 2만원 이상이거나 5백원 이하이면 환불 불가능
			if (a >= 20000 || a <= 500)
				continue;

			for (int j = 0; j < MOD; j++) {
				x = (j + (a - 500) / 10) % MOD;
				dp[1 - p][x] = Math.max(dp[1 - p][x], dp[p][x]);

				if (dp[p][j] == -1)
					continue;

				dp[1 - p][x] = Math.max(dp[1 - p][x], dp[p][j] + a - 500);
			}

			p = 1 - p;
		}

		int answer = dp[p][0];

		System.out.println(answer);
	}
}