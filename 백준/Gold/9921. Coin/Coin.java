import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int value = Integer.parseInt(st.nextToken());
		int weight = Integer.parseInt(st.nextToken());

		int[][] dp = new int[value + 1][weight + 1];

		for (int i = 0; i <= value; i++) {
			Arrays.fill(dp[i], INF);
		}

		dp[0][0] = 0;

		int v, w;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			for (int i = 0; i + v <= value; i++) {
				for (int j = 0; j + w <= weight; j++) {
					if (dp[i][j] == INF)
						continue;
					dp[i + v][j + w] = Math.min(dp[i + v][j + w], dp[i][j] + 1);
				}
			}
		}

		int answer = dp[value][weight] == INF ? 0 : dp[value][weight];

		System.out.println(answer);
	}
}