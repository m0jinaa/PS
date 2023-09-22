import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static double[][][] dp;
	static int[] dx = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dy = new int[] { 2, 1, -1, -2, -2, -1, 1, 2 };

	static boolean inRange(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > n)
			return false;
		return true;
	}

	static double move(int x, int y, int c) {
		if (c == k)
			return dp[x][y][c] = 1;
		else if (dp[x][y][c] != -1)
			return dp[x][y][c];
		double p = 0;
		int nx, ny;

		for (int i = 0; i < 8; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (!inRange(nx, ny))
				continue;
			p += move(nx, ny, c + 1) / 8;
		}

		return dp[x][y][c] = p;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new double[n + 1][n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		double answer = move(x, y, 0);

		System.out.println(answer);
	}
}