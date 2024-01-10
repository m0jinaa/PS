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

		int[][] dp = new int[m + 1][m + 1];

		for (int i = 0; i <= m; i++) {
			Arrays.fill(dp[i], -1);
		}

		dp[0][0] = 0;

		for (Player p : player) {

			for (int i = m; i >= 0; i--) {
				for (int j = m; j >= 0; j--) {

					if (i > 0 && dp[i - 1][j] != -1) {
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + p.w);
					}

					if (j > 0 && dp[i][j - 1] != -1) {
						dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + p.b);
					}
				}
			}
		}

		System.out.println(dp[m][m]);
	}
}