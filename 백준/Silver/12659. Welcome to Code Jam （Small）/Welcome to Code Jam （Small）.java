import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		char[] row;
		int[] dp = new int[19];
		final int MOD = 10000;

		for (int t = 1; t <= tc; t++) {
			row = br.readLine().toCharArray();

			Arrays.fill(dp, 0);
			for (char c : row) {
				switch (c) {
				case 'w':
					dp[0] = (dp[0] + 1) % MOD;
					break;

				case 'e':
					dp[14] = (dp[14] + dp[13]) % MOD;
					dp[6] = (dp[6] + dp[5]) % MOD;
					dp[1] = (dp[1] + dp[0]) % MOD;
					break;

				case 'l':
					dp[2] = (dp[2] + dp[1]) % MOD;
					break;

				case 'c':
					dp[11] = (dp[11] + dp[10]) % MOD;
					dp[3] = (dp[3] + dp[2]) % MOD;
					break;

				case 'o':
					dp[12] = (dp[12] + dp[11]) % MOD;
					dp[9] = (dp[9] + dp[8]) % MOD;
					dp[4] = (dp[4] + dp[3]) % MOD;
					break;

				case 'm':
					dp[18] = (dp[18] + dp[17]) % MOD;
					dp[5] = (dp[5] + dp[4]) % MOD;
					break;

				case ' ':
					dp[15] = (dp[15] + dp[14]) % MOD;
					dp[10] = (dp[10] + dp[9]) % MOD;
					dp[7] = (dp[7] + dp[6]) % MOD;
					break;

				case 't':
					dp[8] = (dp[8] + dp[7]) % MOD;
					break;

				case 'd':
					dp[13] = (dp[13] + dp[12]) % MOD;
					break;

				case 'j':
					dp[16] = (dp[16] + dp[15]) % MOD;
					break;

				case 'a':
					dp[17] = (dp[17] + dp[16]) % MOD;
					break;
				}
			}

			sb.append(String.format("Case #%d: %04d\n", t, dp[18]));
		}

		System.out.print(sb.toString());
	}
}