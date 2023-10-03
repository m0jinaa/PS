import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][][] dp;
	static Merchant[] merchants;
	static int gg, g, c, n;

	static class Merchant {
		String type;
		int p, s;

		public Merchant(String type, int p, int s) {
			super();
			this.type = type;
			this.p = p;
			this.s = s;
		}
	}

	static int getMax() {
		dp[1][c][0] = 0;
		int nc, ng = 0;
		int ind = 0;
		for (Merchant merchant : merchants) {
			for (int i = c; i >= 0; i--) {
				for (int j = gg - 1; j >= 0; j--) {
					if (dp[1 - ind][i][j] == -1)
						continue;
					dp[ind][i][j] = Math.max(dp[ind][i][j], dp[1 - ind][i][j]);
					// 잔돈으로 계산
					if (j >= merchant.s) {
						nc = i;
						ng = j - merchant.s;

						dp[ind][nc][ng] = Math.max(dp[ind][nc][ng], dp[1 - ind][nc][ng]);

						dp[ind][nc][ng] = Math.max(dp[ind][nc][ng], dp[1 - ind][i][j] + 1);
					}

					// 골드로 계산
					nc = i - 1;
					switch (merchant.type) {
					case "greedy":
						ng = j + ((g - merchant.s) / merchant.p) * merchant.p;
						break;
					case "generous":
						ng = j + ((int) Math.ceil((g - merchant.s) * 1.0 / merchant.p)) * merchant.p;
						break;
					case "honest":
						ng = j + ((int) Math.round((g - merchant.s) * 1.0 / merchant.p)) * merchant.p;
						break;
					}
					if (nc >= 0 && ng < gg && !("generous".equals(merchant.type) && j >= merchant.s)) {
						dp[ind][nc][ng] = Math.max(dp[ind][nc][ng], dp[1 - ind][nc][ng]);
						dp[ind][nc][ng] = Math.max(dp[ind][nc][ng], dp[1 - ind][i][j] + 1);
					}
				}
			}
			ind = 1 - ind;
		}

		int answer = 0;
		for (int i = 0; i <= c; i++) {
			for (int j = 0; j < gg; j++) {
				answer = Math.max(answer, dp[1 - ind][i][j]);
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		g = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		merchants = new Merchant[n];

		String type;
		int p, s;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			type = st.nextToken();
			p = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			merchants[i] = new Merchant(type, p, s);
		}

		gg = g * n + 1;

		dp = new int[2][c + 1][gg];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j <= c; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		int answer = getMax();

		System.out.println(answer);
	}
}