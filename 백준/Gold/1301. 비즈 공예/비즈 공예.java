import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static long[][][][][][][] dp;

	static long getCnt(int[] marble, int prev1, int prev2) {
		if (marble[0] + marble[1] + marble[2] + marble[3] + marble[4] == 0)
			return dp[marble[0]][marble[1]][marble[2]][marble[3]][marble[4]][prev1][prev2] = 1L;
		else if (dp[marble[0]][marble[1]][marble[2]][marble[3]][marble[4]][prev1][prev2] != -1)
			return dp[marble[0]][marble[1]][marble[2]][marble[3]][marble[4]][prev1][prev2];

		long cnt = 0;

		for (int i = 0; i < 5; i++) {
			if (marble[i] == 0 || prev1 == i + 1 || prev2 == i + 1)
				continue;
			marble[i]--;
			cnt += getCnt(marble, prev2, i + 1);
			marble[i]++;

		}

		return dp[marble[0]][marble[1]][marble[2]][marble[3]][marble[4]][prev1][prev2] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] marble = new int[5];

		for (int i = 0; i < n; i++) {
			marble[i] = Integer.parseInt(br.readLine());
		}

		dp = new long[marble[0] + 1][marble[1] + 1][marble[2] + 1][marble[3] + 1][marble[4] + 1][n + 1][n + 1];

		// 초기화
		for (int i = 0; i <= marble[0]; i++) {
			for (int j = 0; j <= marble[1]; j++) {
				for (int w = 0; w <= marble[2]; w++) {
					for (int v = 0; v <= marble[3]; v++) {
						for (int u = 0; u <= marble[4]; u++) {
							for (int z = 0; z <= n; z++) {
								Arrays.fill(dp[i][j][w][v][u][z], -1);
							}
						}
					}
				}
			}
		}

		long answer = getCnt(marble, 0, 0);

		System.out.println(answer);
	}
}
