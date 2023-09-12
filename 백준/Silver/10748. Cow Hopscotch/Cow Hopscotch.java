import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int r, c, k;
	static long[][] dp;
	static int[][] map;
	static final int MOD = 1_000_000_007;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= r || y < 0 || y >= c)
			return false;
		return true;
	}

	static long getCnt(int x, int y) {
		if (dp[x][y] != -1)
			return dp[x][y];
		else if (x == r - 1 && y == c - 1)
			return dp[x][y] = 1;
		long cnt = 0;

		for (int i = x + 1; i < r; i++) {
			for (int j = y + 1; j < c; j++) {
				if (map[i][j] == map[x][y])
					continue;
				cnt += getCnt(i, j);
				cnt %= MOD;
			}
		}
		return dp[x][y] = cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		dp = new long[r][c];
		for (int i = 0; i < r; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(dp[i], -1);
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(getCnt(0, 0));
	}
}