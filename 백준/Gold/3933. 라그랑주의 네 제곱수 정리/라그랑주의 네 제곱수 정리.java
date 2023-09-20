import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][][] dp;
	static final int MAX = 1 << 15;
	static final int CNT = 5;
	static final int NUM = 183;

	static int getCnt(int x, int n, int c) {
		if (dp[x][n][c] != -1)
			return dp[x][n][c];

		int cnt = 0;
		int now;
		now = n * n;
		if (x >= now && c > 0) {
			for (int i = 0; i <= n; i++) {
				cnt += getCnt(x - now, i, c - 1);
			}
		}

		return dp[x][n][c] = cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		dp = new int[MAX][NUM][CNT];

		for (int i = 1; i < MAX; i++) {
			for (int j = 0; j < NUM; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		dp[0][0][0] = 1;

		int x;
		int answer;
		while (true) {
			x = Integer.parseInt(br.readLine());
			if (x == 0)
				break;
			answer = 0;
			for (int i = 1; i < NUM; i++) {
				for (int j = 1; j < CNT; j++) {
					answer += getCnt(x, i, j);
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}