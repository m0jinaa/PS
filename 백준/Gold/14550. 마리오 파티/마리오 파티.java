import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, s, t;
	static int[] nums;
	static int[][] dp;
	static final int INF = -1_000_000_007;
	static final int CANT_ARRIVED = -2000001;

	static int getMax(int x, int c) {
		if (x > n) {
			if (c == t)
				return 0;
			else
				return CANT_ARRIVED;
		} else if (c == t) {
			return dp[x][c] = CANT_ARRIVED;
		} else if (dp[x][c] != INF)
			return dp[x][c];

		int coin = CANT_ARRIVED;
		int temp;
		for (int i = 1; i <= s; i++) {
			temp = getMax(x + i, c + 1);
			if (temp == CANT_ARRIVED)
				continue;
			coin = Math.max(coin, temp + nums[x]);
		}

		return dp[x][c] = coin;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int ind;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			nums = new int[n + 1];

			dp = new int[n + 1][t + 1];

			ind = 1;

			while (ind <= n) {
				st = new StringTokenizer(br.readLine(), " ");

				while (st.hasMoreTokens()) {
					nums[ind++] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i <= n; i++) {
				Arrays.fill(dp[i], INF);
			}

			sb.append(getMax(0, 0)).append("\n");
		}

		System.out.println(sb.toString());
	}
}