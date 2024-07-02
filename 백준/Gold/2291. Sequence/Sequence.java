import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][][] dp;
	static int[] answer;

	static int getCnt(int x, int s, int d) {
		if (x == n && s == m) {
			return dp[x][s][d] = 1;
		} else if (s == m || x == n)
			return dp[x][s][d] = 0;
		else if (dp[x][s][d] != -1)
			return dp[x][s][d];

		int cnt = 0;

		for (int y = d; s + y <= m; y++) {
			cnt += getCnt(x + 1, s + y, y);
		}

		return dp[x][s][d] = cnt;
	}

	static void getAnswer(int x, int s, int d, int c) {
		if (x == n)
			return;
		for (int y = d; y <= m; y++) {
			if (dp[x + 1][s + y][y] == -1)
				continue;
			else if (dp[x + 1][s + y][y] < c) {
				c -= dp[x + 1][s + y][y];
				continue;
			}

			answer[x] = y;
			getAnswer(x + 1, s + y, y, c);
			break;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		dp = new int[n + 1][m + 1][m + 1];
		answer = new int[n];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++)
				Arrays.fill(dp[i][j], -1);
		}

		getCnt(0, 0, 1);

		getAnswer(0, 0, 1, k);

		for (int i = 0; i < n; i++) {
			sb.append(answer[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}