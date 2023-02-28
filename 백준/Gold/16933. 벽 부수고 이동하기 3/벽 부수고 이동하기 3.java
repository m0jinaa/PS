import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	static final int INF = 200_000_000;
	static int n, m;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Loc {
		int x, y, d, c;

		public Loc(int x, int y, int d, int c) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}
	}

	static boolean inRange(int a, int b) {
		if (a < 0 || a >= n || b < 0 || b >= m)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][][][] dp = new int[n][m][2][k + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Arrays.fill(dp[i][j][0], INF);
				Arrays.fill(dp[i][j][1], INF);
			}
		}
		dp[0][0][0][0] = 1;

		int[][] map = new int[n][m];
		char[] arr;
		for (int i = 0; i < n; i++) {
			arr = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = arr[j] - '0';
			}
		}

		LinkedList<Loc> q = new LinkedList<Loc>();

		q.add(new Loc(0, 0, 0, 0));
		Loc now;
		int nx, ny;
		int ans = -1;
		while (!q.isEmpty()) {

			now = q.pollFirst();

			if (now.x == n - 1 && now.y == m - 1) {
				ans = dp[now.x][now.y][now.d][now.c];
				break;
			}
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny)) // 격자 밖으로 벗어나는 경우
					continue;

				if (now.d == 1 && map[nx][ny] == 1) // 지금이 밤이고 가고자하는 곳이 벽인 경우
					continue;

				if (map[nx][ny] == 1 && now.c < k
						&& dp[nx][ny][1 - now.d][now.c + 1] > dp[now.x][now.y][now.d][now.c] + 1) {
					dp[nx][ny][1 - now.d][now.c + 1] = dp[now.x][now.y][now.d][now.c] + 1;
					q.add(new Loc(nx, ny, 1 - now.d, now.c + 1));
				} else if (map[nx][ny] == 0 && dp[nx][ny][1 - now.d][now.c] > dp[now.x][now.y][now.d][now.c] + 1) {
					dp[nx][ny][1 - now.d][now.c] = dp[now.x][now.y][now.d][now.c] + 1;
					q.add(new Loc(nx, ny, 1 - now.d, now.c));
				}

			}
			if (dp[now.x][now.y][1 - now.d][now.c] > dp[now.x][now.y][now.d][now.c] + 1) {
				dp[now.x][now.y][1 - now.d][now.c] = dp[now.x][now.y][now.d][now.c] + 1;
				q.add(new Loc(now.x, now.y, 1 - now.d, now.c));
			}
		}

		System.out.println(ans);
	}
}