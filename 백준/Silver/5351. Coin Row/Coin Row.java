import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dp;
	static int[] coins;

	static int getMax(int x) {
		if (x >= n)
			return 0;
		else if (dp[x] != -1)
			return dp[x];

		int max = 0;

		max = Math.max(max, coins[x] + getMax(x + 2));
		max = Math.max(max, getMax(x + 1));

		return dp[x] = max;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int answer;

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = st.countTokens();
			coins = new int[n];
			dp = new int[n];

			for (int i = 0; i < n; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
				dp[i] = -1;
			}

			answer = getMax(0);

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}
