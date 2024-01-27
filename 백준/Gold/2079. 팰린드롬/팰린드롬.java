import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int INF = 1_000_000_007;
	static int n;
	static char[] word;
	static int[] dp;

	static boolean isPalindrom(int s, int e) {
		while (s <= e) {
			if (word[s] != word[e])
				return false;
			s++;
			e--;
		}
		return true;
	}

	static int getMin(int x) {
		if (dp[x] != INF)
			return dp[x];
		int cnt = INF;
		for (int i = 0; i < x; i++) {
			if (isPalindrom(x - i, x)) {
				cnt = Math.min(cnt, getMin(x - i - 1) + 1);
			}
		}

		return dp[x] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		word = (" " + br.readLine()).toCharArray();
		n = word.length;

		dp = new int[n];

		Arrays.fill(dp, INF);

		dp[0] = 0;

		int answer = getMin(n - 1);

		System.out.println(answer);
	}
}