import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] medicine;
	static int[][] dp;
	static char[] day = new char[] { 'B', 'L', 'D' };

	static int getMax(int s, int e, int d) {
		if (s > e)
			return 0;

		if (dp[s][e] != -1)
			return dp[s][e];

		int max = 0;

		if (medicine[s] == day[d])
			max = Math.max(max, getMax(s + 1, e, (d + 1) % 3) + 1);

		if (medicine[e] == day[d])
			max = Math.max(max, getMax(s, e - 1, (d + 1) % 3) + 1);

		return dp[s][e] = max;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()) * 3;

		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		medicine = br.readLine().toCharArray();

		System.out.println(getMax(0, n - 1, 0));
	}
}