import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int r, c;
		char[][] map;
		int[][] dp;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			map = new char[r + 1][];
			dp = new int[r + 1][c + 1];

			for (int i = 1; i <= r; i++) {
				map[i] = (" " + br.readLine()).toCharArray();
			}

			for (int i = 1; i <= r; i++) {
				for (int j = 1; j <= c; j++) {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + (map[i][j] == 'C' ? 1 : 0);
				}
			}

			sb.append(dp[r][c]).append("\n");
		}

		System.out.print(sb.toString());
	}
}