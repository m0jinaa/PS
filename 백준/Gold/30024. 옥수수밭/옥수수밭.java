import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] v;

	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static int n, m;

	static boolean inRange(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y >= m)
			return false;
		return true;
	}

	static class Loc implements Comparable<Loc> {
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Loc l) {
			return map[l.x][l.y] - map[this.x][this.y];
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		v = new boolean[n + 1][m + 1];

		PriorityQueue<Loc> q = new PriorityQueue<>();

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i == 1 || i == n || j == 1 || j == m) {
					v[i][j] = true;
					q.add(new Loc(i, j));
				}
			}
		}

		int k = Integer.parseInt(br.readLine());

		Loc now;
		int nx, ny;

		while (k-- > 0 && !q.isEmpty()) {
			now = q.poll();
			sb.append(now.x).append(" ").append(now.y).append("\n");

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || v[nx][ny])
					continue;
				q.add(new Loc(nx, ny));
				v[nx][ny] = true;
			}
		}

		System.out.print(sb.toString());
	}
}