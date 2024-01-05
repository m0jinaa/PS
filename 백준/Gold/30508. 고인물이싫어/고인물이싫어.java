import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int n, m;
	static int[][] v;
	static int[][] sum;
	static int[][] map;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static LinkedList<Node> q;

	static boolean inRange(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > m)
			return false;
		return true;
	}

	static void bfs() {
		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[nx][ny] < map[now.x][now.y] || v[nx][ny] != 0)
					continue;
				v[nx][ny] = 1;
				q.add(new Node(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		v = new int[n + 1][m + 1];
		sum = new int[n + 1][m + 1];
		q = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int k = Integer.parseInt(br.readLine());

		int x, y;

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			q.add(new Node(x, y));
			v[x][y] = 1;
		}
		// 물빠진 자리 찾기
		bfs();

		// 누적합
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + v[i][j];
			}
		}

		int space = h * w;

		int cnt = 0;
		int total;
		for (int i = h; i <= n; i++) {
			for (int j = w; j <= m; j++) {
				total = sum[i][j] - sum[i - h][j] - sum[i][j - w] + sum[i - h][j - w];
				if (total == space) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}