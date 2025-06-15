import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static int[][][] dp;
	static final int[] dx = new int[] { 0, 0, 1, -1, 0 };
	static final int[] dy = new int[] { 1, -1, 0, 0, 0 };

	static class Node {
		int x, y, b, t;

		public Node(int x, int y, int b, int t) {
			super();
			this.x = x;
			this.y = y;
			this.b = b;
			this.t = t;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MAX_B = 100;
		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		LinkedList<Node> q = new LinkedList<>();
		dp = new int[n][m][MAX_B + 1];
		map = new char[n][];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				Arrays.fill(dp[i][j], INF);
				if (map[i][j] == 'S') {
					q.add(new Node(i, j, 0, 0));
					dp[i][j][0] = 0;
				}
			}
		}

		Node now;
		int nx, ny, nb;

		int time = INF;

		while (!q.isEmpty()) {
			now = q.poll();

			if (map[now.x][now.y] == 'E') {
				time = now.t;
				break;
			}

			for (int i = 0; i < 5; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '#')
					continue;

				// 집이거나 건물일 때
				if (map[nx][ny] == 'H' || map[nx][ny] == 'S') {
					nb = Math.max(0, now.b - k);
				} else {
					nb = Math.min(100, now.b + c);
				}

				if (nb >= 100 || dp[nx][ny][nb] <= now.t + 1)
					continue;

				dp[nx][ny][nb] = now.t + 1;
				q.add(new Node(nx, ny, nb, now.t + 1));
			}
		}

		System.out.println(time == INF ? -1 : time);
	}
}