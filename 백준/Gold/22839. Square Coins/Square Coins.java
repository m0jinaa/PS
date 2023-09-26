import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] coins = new int[] { 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289 };
	static int[] dp;

	static void init() {
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i < 301; i++) {
				dp[i] += dp[i - coin];
			}
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		dp = new int[301];

		init();

		int x;
		while (true) {
			x = Integer.parseInt(br.readLine());
			if (x == 0)
				break;
			sb.append(dp[x]).append("\n");
		}

		System.out.println(sb.toString());

	}
}