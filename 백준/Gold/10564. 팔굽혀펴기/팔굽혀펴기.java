import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static final int INF = 1_000_000_007;
	static int[] score;
	static int[][] dp;

	static int getMax(int x, int s) {
		if (x == 0)
			return 0;
		else if (dp[x][s] != -1)
			return dp[x][s];

		int ret = -INF;

		for (int y : score) {
			if (x - s * y < 0)
				continue;
			ret = Math.max(ret, getMax(x - s * y, s + 1) + y);
		}

		return dp[x][s] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int m, answer;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			score = new int[m];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < m; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}

			dp = new int[n + 1][101];

			for (int i = 0; i <= n; i++) {
				Arrays.fill(dp[i], -1);
			}

			answer = getMax(n, 1);

			sb.append(answer <= 0 ? -1 : answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}