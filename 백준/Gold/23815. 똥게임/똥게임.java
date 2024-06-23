import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][][] dp = new int[n + 1][2][2];

		dp[0][0][0] = 1;

		char[] option;
		int c;
		boolean impossible = false;

		int x;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				option = st.nextToken().toCharArray();

				x = option[1] - '0';
				for (int k = 0; k < 2; k++) {

					switch (option[0]) {
					case '+':
						if (dp[i - 1][k][0] > 0) {
							dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][k][0] + x);
							dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][k][0]);
						}
						if (dp[i - 1][k][1] > 0)
							dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][k][1] + x);
						break;
					case '-':
						if (dp[i - 1][k][0] > 0) {
							dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][k][0] - x);
							dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][k][0]);
						}
						if (dp[i - 1][k][1] > 0)
							dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][k][1] - x);
						break;
					case '*':
						if (dp[i - 1][k][0] > 0) {
							dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][k][0] * x);
							dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][k][0]);
						}
						if (dp[i - 1][k][1] > 0)
							dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][k][1] * x);
						break;
					case '/':
						if (dp[i - 1][k][0] > 0) {
							dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][k][0] / x);
							dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][k][0]);
						}
						if (dp[i - 1][k][1] > 0)
							dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][k][1] / x);
						break;
					}
				}
			}

			c = 0;

			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					if (dp[i][j][k] <= 0)
						c++;
				}
			}

			if (c == 4) {
				impossible = true;
				break;
			}
		}

		if (impossible) {
			System.out.println("ddong game");
		} else {
			int answer = 0;

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					answer = Math.max(answer, dp[n][i][j]);
				}
			}

			System.out.println(answer);
		}
	}
}