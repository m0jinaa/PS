import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[] dx = new int[] { 0, 1 };
	static int[] dy = new int[] { 1, 0 };

	static char[][] map;
	static int[][] dp;

	static boolean inRange(int x, int y) {
		if (x >= n || y >= m)
			return false;
		return true;
	}

	static int move(int x, int y) {
		if (dp[x][y] != -1)
			return dp[x][y];
		int ret = 0;

		int nx, ny;

		for (int i = 0; i < 2; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (!inRange(nx, ny) || map[nx][ny] == '#')
				continue;
			else if (move(nx, ny) == 0)
				ret = 1;
		}

		for (int i = 1; i <= k; i++) {
			nx = x + i;
			ny = y + i;
			if (!inRange(nx, ny))
				break;
			else if (map[nx][ny] == '#')
				continue;
			else if (move(nx, ny) == 0)
				ret = 1;
		}

		return dp[x][y] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new char[n][];
		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(dp[i], -1);
		}

		dp[n - 1][m - 1] = 0;

		int t = Integer.parseInt(br.readLine());

		int x, y;

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;

			sb.append(move(x, y) == 1 ? "First\n" : "Second\n");
		}

		System.out.print(sb.toString());
	}
}