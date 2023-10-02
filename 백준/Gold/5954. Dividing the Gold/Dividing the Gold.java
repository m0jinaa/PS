import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, total;
	static int[] coins;
	static int[] dp;
	static boolean[] v;
	static final int MOD = 1_000_000;

	static int fill() {

		dp[0] = 1;
		v[0] = true;

		for (int x : coins) {
			for (int j = total; j >= x; j--) {
				dp[j] += dp[j - x];
				if (v[j - x])
					v[j] = true;
				dp[j] %= MOD;
			}
		}

		int x = (total + 1) / 2;

		while (x <= total && !v[x]) {
			x++;
		}

		return x;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		coins = new int[n];
		total = 0;

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
			total += coins[i];
		}

		dp = new int[total + 1];
		v = new boolean[total + 1];
		int x = fill();

		int answer = 2 * x - total;

		sb.append(answer).append("\n").append(dp[x]);

		System.out.println(sb.toString());

	}
}