import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] word = (" " + br.readLine()).toCharArray();

		int n = word.length;

		int[][] dp = new int[n][2];

		dp[0][0] = 0;
		dp[0][1] = 1;

		for (int i = 1; i < n; i++) {
			if (word[i] <= 'Z') { // 대문자
				dp[i][0] = Math.min(dp[i - 1][0] + 2, dp[i - 1][1] + 2);
				dp[i][1] = Math.min(dp[i - 1][1] + 1, dp[i - 1][0] + 2);
			} else { // 소문자
				dp[i][0] = Math.min(dp[i - 1][0] + 1, dp[i - 1][1] + 2);
				dp[i][1] = Math.min(dp[i - 1][1] + 2, dp[i - 1][0] + 2);
			}
		}

		int answer = Math.min(dp[n - 1][0], dp[n - 1][1]);

		System.out.println(answer);
	}
}