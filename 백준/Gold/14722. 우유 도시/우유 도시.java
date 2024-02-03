import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dx = new int[] { 0, 1 };
	static int[] dy = new int[] { 1, 0 };
	static int[][] map;
	static int[][][] dp;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static int getMax(int x, int y, int t) {
		if (dp[x][y][t] != -1)
			return dp[x][y][t];
		if (x == n - 1 && y == n - 1) {
			if (map[x][y] == t) {
				return dp[x][y][t] = 1;
			} else {
				return dp[x][y][t] = 0;
			}
		}

		int cnt = 0;
		int nx, ny, nt;
		if (map[x][y] == t) {// 마실 수 있을 때
			for (int i = 0; i < 2; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				nt = (t + 1) % 3;

				if (!inRange(nx, ny))
					continue;

				cnt = Math.max(cnt, getMax(nx, ny, nt) + 1);
			}
		}
		for (int i = 0; i < 2; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			nt = t;

			if (!inRange(nx, ny))
				continue;

			cnt = Math.max(cnt, getMax(nx, ny, t));
		}

		return dp[x][y][t] = cnt;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		dp = new int[n][n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i][j], -1);
			}
		}

		int answer = getMax(0, 0, 0);

		System.out.println(answer);
	}
}