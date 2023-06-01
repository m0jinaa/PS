import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int n, m;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static class Part implements Comparable<Part> {
		int x, y, h;

		public Part(int x, int y, int h) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;
		}

		@Override
		public int compareTo(Part p) {
			return this.h - p.h;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		int[] dx = new int[] { 0, 0, 1, -1 };
		int[] dy = new int[] { 1, -1, 0, 0 };

		boolean[][] v = new boolean[n][m];

		PriorityQueue<Part> q = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
					q.add(new Part(i, j, map[i][j]));
					v[i][j] = true;
				}
			}
		}
		Part now;
		int nx, ny,diff;
		int water = 0;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || v[nx][ny])
					continue;
				v[nx][ny] = true;
				diff = now.h-map[nx][ny];
				water+=diff<0?0:diff;
				q.add(new Part(nx,ny,Math.max(now.h, map[nx][ny])));
			}
		}
		
		System.out.println(water);

	}
}