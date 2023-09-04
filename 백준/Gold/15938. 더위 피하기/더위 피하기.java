import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int sx, sy, n, t, ex, ey;
	static final int MOD = 1_000_000_007;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static long[][][] dp;
	static HashSet<Node> obstacle;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

	static long getCnt(int x, int y, int c) {
		int nx = sx + x;
		int ny = sy + y;

		if (nx == ex && ny == ey)
			return dp[x + t][y + t][c] = 1;
		else if (Math.abs(ex - nx) + Math.abs(ey - ny) > t - c) {
			return dp[x + t][y + t][c] = 0;
		} else if (t == c) {
			return dp[x + t][y + t][c] = 0;
		} else if (dp[x + t][y + t][c] != -1)
			return dp[x + t][y + t][c];

		long cnt = 0;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (obstacle.contains(new Node(nx + sx, ny + sy))) {
				continue;
			}

			cnt = (cnt + getCnt(nx, ny, c + 1)) % MOD;
		}

		return dp[x + t][y + t][c] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		sx = Integer.parseInt(st.nextToken()) + 100000;
		sy = Integer.parseInt(st.nextToken()) + 100000;

		t = Integer.parseInt(br.readLine());

		n = 2 * t + 1;

		dp = new long[n][n][t + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		st = new StringTokenizer(br.readLine(), " ");

		ex = Integer.parseInt(st.nextToken()) + 100000;
		ey = Integer.parseInt(st.nextToken()) + 100000;

		int m = Integer.parseInt(br.readLine());

		obstacle = new HashSet<>();

		int x, y;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken()) + 100000;
			y = Integer.parseInt(st.nextToken()) + 100000;


			obstacle.add(new Node(x,y));
		}


		long answer = getCnt(0,0,0);

		System.out.println(answer);
	}
}