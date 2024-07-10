import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] dp;
	static int[][] map;

	static int getMax(int x, int y) {
		if (dp[x][y] != -1)
			return dp[x][y];
		else if (x == n - 1)
			return dp[x][y] = map[x][y];

		int max = Math.max(getMax(x + 1, y), getMax(x + 1, y + 1)) + map[x][y];

		return dp[x][y] = max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		int answer = getMax(0, 0);

		System.out.println(answer);
	}
}