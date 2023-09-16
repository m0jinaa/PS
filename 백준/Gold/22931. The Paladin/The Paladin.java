import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] cost;
	static int[][] dp;
	static final int INF = 1_000_000;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int l = (k + 1) / 2;

		cost = new int[26][26];

		dp = new int[26][k + 1];

		for (int i = 0; i < 26; i++) {
			Arrays.fill(dp[i], INF);
			Arrays.fill(cost[i], INF);
			dp[i][0] = 0;
		}

		String s;
		int a, b, c;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			s = st.nextToken();
			a = s.charAt(0) - 'a';
			b = s.charAt(1) - 'a';
			c = Integer.parseInt(st.nextToken());

			cost[a][b] = c;
		}

		for (int i = 1; i < l; i++) {
			for (int x = 0; x < 26; x++) {
				for (int y = 0; y < 26; y++) {
					dp[y][i] = Math.min(dp[y][i], dp[x][i - 1] + cost[x][y] + cost[y][x]);
				}
			}
		}

		if (k % 2 == 0) {
			for (int i = 0; i < 26; i++) {
				if (dp[i][l - 1] == INF)
					continue;
				dp[i][l - 1] = cost[i][i] == INF ? INF : dp[i][l - 1] + cost[i][i];
			}
		}

		int answer = INF;

		for (int i = 0; i < 26; i++) {
			answer = Math.min(answer, dp[i][l - 1]);
		}

		System.out.println(answer == INF ? -1 : answer);
	}
}