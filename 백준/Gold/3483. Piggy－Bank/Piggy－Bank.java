import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	static final int INF = 1_000_000_007;
	static int[][] coins;

	static void fill(int x) {
		dp = new int[x + 1];
		Arrays.fill(dp, INF);

		dp[0] = 0;
		int p, w;
		for (int[] coin : coins) {
			p = coin[0];
			w = coin[1];

			for (int i = w; i <= x; i++) {
				dp[i] = Math.min(dp[i], dp[i - w] + p);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		int e, f, n, p, w, x;
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			e = Integer.parseInt(st.nextToken());
			f = Integer.parseInt(st.nextToken());

			x = f - e;

			n = Integer.parseInt(br.readLine());

			coins = new int[n][2];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				p = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				coins[i][0] = p;
				coins[i][1] = w;
			}

			fill(x);

			if (dp[x] == INF) {
				sb.append("This is impossible.\n");
			} else {
				sb.append("The minimum amount of money in the piggy-bank is ").append(dp[x]).append(".\n");
			}
		}

		System.out.print(sb.toString());
	}
}