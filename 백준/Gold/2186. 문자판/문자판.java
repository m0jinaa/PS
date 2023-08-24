import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, l;
	static char[][] map;
	static char[] word;
	static int[][][] dp;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int dfs(int x, int y, int t) {
		if (dp[x][y][t] != -1)
			return dp[x][y][t];
		else if (t == l - 1) {
			return dp[x][y][t] = 1;
		}
		int nx, ny;
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= k; j++) {
				nx = x + dx[i] * j;
				ny = y + dy[i] * j;

				if (!inRange(nx, ny) || map[nx][ny] != word[t + 1])
					continue;
				cnt += dfs(nx, ny, t + 1);
			}
		}

		return dp[x][y][t] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new char[n][];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		word = br.readLine().toCharArray();

		l = word.length;

		dp = new int[n][m][l];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == word[0]) {
					answer += dfs(i, j, 0);
				}
			}
		}

		System.out.println(answer);
	}
}