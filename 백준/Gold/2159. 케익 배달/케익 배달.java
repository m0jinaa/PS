import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dx = new int[] { 0, 0, 0, 1, -1 };
	static int[] dy = new int[] { 0, 1, -1, 0, 0 };
	static int max = 1_000_001;
	static long[][] dp;
	static final long INF = 1_000_000_000_000_000_001L;
	static Loc[] locs;

	static class Loc {
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= max || y < 0 || y >= max)
			return false;
		return true;
	}

	static long getMin(int ind, int d) {
		if (ind >= n)
			return 0;
		else if (dp[ind][d] != -1)
			return dp[ind][d];
		long dist = INF;

		int cx = locs[ind].x + dx[d];
		int cy = locs[ind].y + dy[d];

		int nx, ny;

		long w;

		for (int i = 0; i < 5; i++) {
			nx = locs[ind + 1].x + dx[i];
			ny = locs[ind + 1].y + dy[i];

			if (!inRange(nx, ny))
				continue;

			w = Math.abs(nx - cx) + Math.abs(ny - cy) + getMin(ind + 1, i);

			dist = Math.min(w, dist);

		}
		return dp[ind][d] = dist;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		locs = new Loc[n + 1];

		int x, y;

		dp = new long[n + 1][5];
		for (int i = 0; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			locs[i] = new Loc(x, y);
			Arrays.fill(dp[i], -1);
		}

		long answer = getMin(0, 0);

		System.out.println(answer);
	}
}