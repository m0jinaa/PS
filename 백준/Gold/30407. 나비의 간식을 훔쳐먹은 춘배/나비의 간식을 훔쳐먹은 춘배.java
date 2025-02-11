import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int h = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] damage = new int[n];

		for (int i = 0; i < n; i++) {
			damage[i] = Integer.parseInt(br.readLine());
		}

		// dp[깜짝 놀라게하기 사용여부][이제까지 받은 냥냥펀치 횟수][네발로 걷기 사용 횟수]
		int[][][] dp = new int[2][n + 1][n + 1];

		dp[0][0][0] = h;

		int v;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				for (int x = 0; x < n; x++) {
					if (dp[i][j][x] == 0)
						continue;
					// 웅크리기
					dp[i][j + 1][x] = Math.max(dp[i][j + 1][x],
							Math.max(0, dp[i][j][x] - Math.max(0, damage[j] - d - k * x) / 2));

					// 네발로걷기
					dp[i][j + 1][x + 1] = Math.max(dp[i][j + 1][x + 1],
							Math.max(0, dp[i][j][x] - Math.max(0, damage[j] - d - k * (x + 1))));

					// 깜짝 놀라게 하기
					if (i == 1)
						continue;
					v = dp[i][j][x] - Math.max(0, damage[j] - d - x * k);
					dp[1][j + 1][x] = Math.max(dp[1][j + 1][x], v);
					if (j + 2 <= n) {
						dp[1][j + 2][x] = Math.max(dp[1][j + 2][x], v);
						dp[1][j + 2][x + 1] = Math.max(dp[1][j + 2][x + 1], v);
					}

				}
			}
		}

		int answer = -1;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j <= n; j++) {
				if (dp[i][n][j] == 0)
					continue;
				answer = Math.max(answer, dp[i][n][j]);
			}
		}

		System.out.println(answer);
	}
}