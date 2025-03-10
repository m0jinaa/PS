import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final char[] LongLong = "longlong".toCharArray();
	static char[] word;
	static int n;

	static boolean check(int ind) {

		for (int i = ind - 7; i <= ind; i++) {
			if (word[i] != LongLong[i - ind + 7])
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		word = (" " + br.readLine()).toCharArray();

		int[] dp = new int[n + 1];

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1];

			if (i < 8 || word[i] != 'g' || !check(i))
				continue;
			dp[i] += dp[i - 8];
		}

		System.out.println(dp[n]);
	}
}