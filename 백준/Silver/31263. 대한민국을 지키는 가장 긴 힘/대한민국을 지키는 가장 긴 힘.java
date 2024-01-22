import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int INF = 1_000_000_007;
	static final int MAX = 5001;
	static int[] num;
	static int[] dp;
	static int n;

	static int getMin(int ind) {
		if (ind >= n)
			return 0;
		if (dp[ind] != INF) {
			return dp[ind];
		}

		int cnt = MAX;

		if (num[ind] == 0)
			return dp[ind] = cnt;
		int d = 0;

		for (int i = 0; i < 3 && ind + i < n; i++) {
			d = d * 10 + num[ind + i];

			if (d <= 641) {
				cnt = Math.min(cnt, getMin(ind + i + 1) + 1);
			}
		}

		return dp[ind] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		char[] row = br.readLine().toCharArray();
		dp = new int[n];
		num = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = row[i] - '0';
			dp[i] = INF;
		}

		int answer = getMin(0);

		System.out.println(answer);
	}
}