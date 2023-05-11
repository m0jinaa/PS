import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 300000;
	static int w, h;
	static int[] dx = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[] dy = new int[] { 1, 1, 1, 0, -1, -1, -1, 0 };

	static class Point implements Comparable<Point>{
		int x, y, fuel;

		public Point(int x, int y, int fuel) {
			super();
			this.x = x;
			this.y = y;
			this.fuel = fuel;
		}

		@Override
		public int compareTo(Point p) {
			return this.fuel-p.fuel;
		}
		
	}

	static boolean inRange(int a, int b) {
		if (a < 0 || a >= h || b < 0 || b >= w) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[h][w];

		char[] row;
		int[][] dp = new int[h][w];
		int targetX = 0, targetY = 0, startX = 0, startY = 0;
		for (int i = 0; i < h; i++) {
			row = br.readLine().toCharArray();
			Arrays.fill(dp[i], INF);
			for (int j = 0; j < w; j++) {
				if (row[j] == '*') {
					targetX = i;
					targetY = j;
					map[i][j] = true;
				} else if (row[j] == 'K') {
					startX = i;
					startY = j;
					map[i][j] = true;
					dp[i][j] = 0;
				} else if (row[j] == '.') {
					map[i][j] = true;
				}
			}
		}

		PriorityQueue<Point> pq = new PriorityQueue<>();

		pq.add(new Point(startX, startY, 0));
		int answer = -1;
		Point now;
		int nx, ny, nfuel;
		while (!pq.isEmpty()) {
			now = pq.poll();
			if (now.x == targetX && now.y == targetY) {
				answer = now.fuel;
				break;
			}

			if (dp[now.x][now.y] < now.fuel)
				continue;

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				
				if (!inRange(nx, ny) || !map[nx][ny])
					continue;
				
				nfuel = now.fuel + (i < 3 ? 0 : 1);

				if (dp[nx][ny] <= nfuel)
					continue;
				dp[nx][ny] = nfuel;
				pq.add(new Point(nx, ny, nfuel));
			}
		}

		System.out.println(answer);
	}
}