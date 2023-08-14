import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static char[] row;
	static boolean[][] isPalindrome;
	static int[] dp;

	static void check() {
		for (int i = 1; i <= n; i++) {
			isPalindrome[i][i] = true;

		}

		for (int i = 1; i < n; i++) {
			if (row[i] != row[i + 1])
				continue;
			isPalindrome[i][i + 1] = true;
		}
		for (int i = 3; i <= n; i++) {
			for (int s = 1, e = s + i - 1; e <= n; s++, e++) {
				isPalindrome[s][e] = ((row[s] == row[e]) && isPalindrome[s + 1][e - 1]);
			}
		}
	}

	public static void count() {
		Arrays.fill(dp, 3000);
		dp[0] = 0;
		dp[1] = 1;
		for (int e = 2; e <= n; e++) {
			for (int m = 1; m <= e; m++) {
				if (isPalindrome[m][e]) {
					dp[e] = Math.min(dp[e], dp[m - 1] + 1);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		row = (" " + br.readLine()).toCharArray();
		n = row.length - 1;

		isPalindrome = new boolean[n + 1][n + 1];
		dp = new int[n + 1];

		check();

		count();

		System.out.println(dp[n]);
	}
}