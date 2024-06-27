import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static char[][] map;
	static int[][][] dp;

	static int[] dx = new int[] { 0, 1 };
	static int[] dy = new int[] { 1, 0 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static int getMax(int x, int y, int t) {
		if (x == n - 1 && y == n - 1)
			return dp[x][y][t] = 0;
		else if (dp[x][y][t] != -1)
			return dp[x][y][t];

		int ret = 0;

		int nx, ny;

		for (int i = 0; i < 2; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (!inRange(nx, ny))
				continue;

			switch (map[nx][ny]) {
			case 'M':
				ret = Math.max(ret, getMax(nx, ny, 1));
				break;
			case 'O':
				ret = Math.max(ret, getMax(nx, ny, (t == 1 ? 2 : 0)));
				break;
			case 'L':
				ret = Math.max(ret, getMax(nx, ny, (t == 2 ? 3 : 0)));
				break;
			case 'A':
				ret = Math.max(ret, getMax(nx, ny, 0) + (t == 3 ? 1 : 0));
				break;
			default:
				ret = Math.max(ret, getMax(nx, ny, 0));
				break;
			}
		}

		return dp[x][y][t] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		dp = new int[n][n][4];

		map = new char[n][];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		int answer = getMax(0, 0, map[0][0] == 'M' ? 1 : 0);

		System.out.println(answer);
	}
}