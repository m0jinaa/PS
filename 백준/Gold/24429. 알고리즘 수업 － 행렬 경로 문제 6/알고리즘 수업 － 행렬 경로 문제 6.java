import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static int[][] dp;

	static class Dot implements Comparable<Dot> {
		int x, y;

		public Dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Dot d) {
			if (this.x != d.x) {
				return this.x - d.x;
			} else {
				return this.y - d.y;
			}
		}
	}

	public static void getMax(int sx, int sy, int ex, int ey) {

		for (int i = sx; i <= ex; i++) {
			for (int j = sy; j <= ey; j++) {
				if (i == sx && j == sy)
					continue;
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + map[i][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(dp[i], -1);
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int p = Integer.parseInt(br.readLine());

		Dot[] dots = new Dot[p + 1];

		int x, y;

		for (int i = 1; i <= p; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			dots[i] = new Dot(x, y);
		}

		dots[0] = new Dot(n, n);

		Arrays.sort(dots);

		int nx = 1;
		int ny = 1;

		dp[1][1] = map[1][1];

		for (Dot d : dots) {
			// 갈 수 없는 경우
			if (d.y < ny) {
				break;
			}

			getMax(nx, ny, d.x, d.y);
			nx = d.x;
			ny = d.y;
		}

		System.out.println(dp[n][n]);
	}
}