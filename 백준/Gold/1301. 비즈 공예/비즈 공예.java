import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static long[][][][][][][] dp;

	static long getCnt(int r, int o, int y, int g, int b, int prev1, int prev2) {
		if (r + o + y + g + b == 0)
			return dp[r][o][y][g][b][prev1][prev2] = 1L;
		else if (dp[r][o][y][g][b][prev1][prev2] != -1)
			return dp[r][o][y][g][b][prev1][prev2];

		long cnt = 0;

		if (r != 0 && prev1 != 1 && prev2 != 1) {
			cnt += getCnt(r - 1, o, y, g, b, prev2, 1);
		}

		if (o != 0 && prev1 != 2 && prev2 != 2) {
			cnt += getCnt(r, o - 1, y, g, b, prev2, 2);
		}

		if (y != 0 && prev1 != 3 && prev2 != 3) {
			cnt += getCnt(r, o, y - 1, g, b, prev2, 3);
		}

		if (g != 0 && prev1 != 4 && prev2 != 4) {
			cnt += getCnt(r, o, y, g - 1, b, prev2, 4);
		}

		if (b != 0 && prev1 != 5 && prev2 != 5) {
			cnt += getCnt(r, o, y, g, b - 1, prev2, 5);
		}

		return dp[r][o][y][g][b][prev1][prev2] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int r = 0;
		int o = 0;
		int y = 0;
		int g = 0;
		int b = 0;

		r = Integer.parseInt(br.readLine());
		o = Integer.parseInt(br.readLine());
		y = Integer.parseInt(br.readLine());

		if (n > 3)
			g = Integer.parseInt(br.readLine());
		if (n > 4)
			b = Integer.parseInt(br.readLine());

		dp = new long[r + 1][o + 1][y + 1][g + 1][b + 1][n + 1][n + 1];

		// 초기화
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= o; j++) {
				for (int w = 0; w <= y; w++) {
					for (int v = 0; v <= g; v++) {
						for (int u = 0; u <= b; u++) {
							for (int z = 0; z <= n; z++) {
								Arrays.fill(dp[i][j][w][v][u][z], -1);
							}
						}
					}
				}
			}
		}

		long answer = getCnt(r, o, y, g, b, 0, 0);

		System.out.println(answer);
	}
}