import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] row;
	static int n;
	static int[][] dp;

	static int getCnt(int s, int e) {
		if (s > e)
			return dp[s][e] = 0;
		else if (s == e) {
			return dp[s][e] = 1;
		} else if (dp[s][e] != -1) {
			return dp[s][e];
		}

		int cnt = 0;

		cnt = getCnt(s, e - 1) + getCnt(s + 1, e);

		if (row[s] == row[e]) {
			cnt++;
		} else {
			cnt -= getCnt(s + 1, e - 1);
		}
		return dp[s][e] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		row = br.readLine().toCharArray();

		n = row.length;

		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		int answer = getCnt(0, n - 1);

		System.out.println(answer);
	}
}