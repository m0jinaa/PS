import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[][] map = new int[r + 2][c + 1];
		int[][] dp = new int[r + 2][c + 1];

		for (int i = 1; i <= r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int j = 1; j <= c; j++) {
			for (int i = 1; i <= r && i <= j; i++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i + 1][j - 1])) + map[i][j];
			}
		}
		
		System.out.println(dp[r][c]);
	}
}