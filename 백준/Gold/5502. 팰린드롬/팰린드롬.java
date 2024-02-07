import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static char[] word;
	static int n;
	static int[][] dp;

	static int getMin(int s, int e) {
		if (s >= e) {
			return dp[s][e] = 0;
		} else if (dp[s][e] != -1)
			return dp[s][e];

		int cnt = n + 1;

		if (word[s] == word[e]) {
			cnt = Math.min(cnt, getMin(s + 1, e - 1));
		} else {
			cnt = Math.min(cnt, getMin(s + 1, e) + 1);
			cnt = Math.min(cnt, getMin(s, e - 1) + 1);
		}

		return dp[s][e] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		word = br.readLine().toCharArray();

		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		int answer = getMin(0, n - 1);

		System.out.println(answer);
	}
}