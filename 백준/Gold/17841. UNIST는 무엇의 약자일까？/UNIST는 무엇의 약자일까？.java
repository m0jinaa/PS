import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[] row;

		int l;

		int[] dp = new int[5];

		final int MOD = 1_000_000_007;

		char[] unist = "UNIST".toCharArray();

		int ind = 0;

		while (n-- > 0) {
			row = br.readLine().toCharArray();
			l = row.length;

			if (row[0] != 'U' && row[0] != 'N' && row[0] != 'I' && row[0] != 'S' && row[0] != 'T')
				continue;
			else if (row[0] == 'U')
				ind = 0;
			else if (row[0] == 'N')
				ind = 1;
			else if (row[0] == 'I')
				ind = 2;
			else if (row[0] == 'S')
				ind = 3;
			else if (row[0] == 'T')
				ind = 4;

			for (int i = 0; ind < 5 && i < l && row[i] == unist[ind]; i++, ind++) {
				if (ind == 0 || ind - i - 1 < 0)
					dp[ind] = (dp[ind] + 1) % MOD;
				else {
					dp[ind] = (dp[ind] + dp[ind - i - 1]) % MOD;
				}
			}
		}

		System.out.println(dp[4]);
	}
}