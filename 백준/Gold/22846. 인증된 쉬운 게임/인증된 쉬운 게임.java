import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] dp;
	static int k;

	static int whoWins(int x) {
		if (x >= k)
			return dp[x] = 0;
		else if (dp[x] != -1)
			return dp[x];

		int limit = (int) Math.sqrt(x);

		int ret = 0;

		for (int i = limit; i > 0 && ret == 0; i--) {
			if (x % i != 0)
				continue;
			if (x + i <= k && whoWins(x + i) == 0)
				return dp[x] = 1;
			if (x + (x / i) <= k && whoWins(x + (x / i)) == 0)
				return dp[x] = 1;

		}

		return dp[x] = 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());

		dp = new int[2 * k + 1];

		Arrays.fill(dp, -1);

		String kali = "Kali";
		String ringo = "Ringo";

		System.out.println(whoWins(1) == 1 ? kali : ringo);
	}
}