import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n;
	static char[][] map;
	static long[][] dp;
	static boolean[][] v;
	static final int MOD = (1 << 31) - 1;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static boolean[][] arrived;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static boolean check() {
		dp[0][0] = 1;
		arrived[0][0] = true;
		for (int i = 1; i < n; i++) {
			if (map[i][0] != '.')
				dp[i][0] = 0;
			else {
				dp[i][0] = dp[i - 1][0];
				arrived[i][0] = arrived[i - 1][0];
			}
			if (map[0][i] != '.')
				dp[0][i] = 0;
			else {
				dp[0][i] = dp[0][i - 1];
				arrived[0][i] = arrived[0][i - 1];
			}

		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (map[i][j] != '.')
					continue;
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
				arrived[i][j] = arrived[i - 1][j] || arrived[i][j - 1];
			}
		}

		return arrived[n - 1][n - 1];
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static boolean canGo() {
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		v[0][0] = true;
		int nx, ny;
		Node now;
		while (!q.isEmpty()) {
			now = q.poll();
			if (now.x == n - 1 && now.y == n - 1) {
				return true;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[nx][ny] != '.' || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new char[n][];
		dp = new long[n][n];
		v = new boolean[n][n];
		arrived = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		if (check()) {
			System.out.println(dp[n - 1][n - 1]);
		} else if (canGo()) {
			System.out.println("THE GAME IS A LIE");
		} else {
			System.out.println("INCONCEIVABLE");
		}
	}
}