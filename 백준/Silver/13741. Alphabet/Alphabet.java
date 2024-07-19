import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] row = br.readLine().toCharArray();

		int n = row.length;

		int[] dp = new int[n];

		dp[0] = 1;

		int max = 1;

		for (int i = 1; i < n; i++) {
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (row[j] < row[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}

			max = Math.max(max, dp[i]);
		}

		int answer = 26 - max;

		System.out.println(answer);
	}
}