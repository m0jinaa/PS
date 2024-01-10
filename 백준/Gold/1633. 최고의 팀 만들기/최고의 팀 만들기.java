import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Player {
		int w, b;

		public Player(int w, int b) {
			super();
			this.w = w;
			this.b = b;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String input;
		int w, b;
		int m = 15;

		LinkedList<Player> player = new LinkedList<>();

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			st = new StringTokenizer(input, " ");
			w = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			player.add(new Player(w, b));
		}

		int n = player.size();

		int[][][] dp = new int[n + 1][m + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		dp[0][0][0] = 0;
		int ind = 0;

		int answer = 0;

		for (Player p : player) {
			ind++;

			for (int i = 0; i <= m; i++) {
				for (int j = 0; j <= m; j++) {
					dp[ind][i][j] = dp[ind - 1][i][j];

					if (i > 0 && dp[ind - 1][i - 1][j] != -1) {
						dp[ind][i][j] = Math.max(dp[ind][i][j], dp[ind - 1][i - 1][j] + p.w);
					}

					if (j > 0 && dp[ind - 1][i][j - 1] != -1) {
						dp[ind][i][j] = Math.max(dp[ind][i][j], dp[ind - 1][i][j - 1] + p.b);
					}

				}
			}
			answer = Math.max(answer, dp[ind][m][m]);
		}

		System.out.println(answer);
	}
}