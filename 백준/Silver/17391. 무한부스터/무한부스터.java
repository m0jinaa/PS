import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static int[][] dp;
	static int[] dx = new int[] { 0, 1 };
	static int[] dy = new int[] { 1, 0 };
	static final int INF = 1_000_000_007;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int getMin(int x, int y) {
		if (dp[x][y] != INF)
			return dp[x][y];
		else if (x == n - 1 && y == m - 1)
			return dp[x][y] = 0;

		int cnt = INF;

		int nx, ny;

		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= map[x][y]; j++) {
				nx = x + dx[i] * j;
				ny = y + dy[i] * j;
				if (!inRange(nx, ny))
					break;
				cnt = Math.min(cnt, getMin(nx, ny) + 1);
			}
		}

		return dp[x][y] = cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(dp[i], INF);
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(getMin(0, 0));
	}
}