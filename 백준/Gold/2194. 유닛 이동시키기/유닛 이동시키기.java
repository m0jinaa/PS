import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, a, b;
	static int[][] sum;
	static int sx, sy, ex, ey;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node {
		int x, y, d;

		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	static boolean canGo(int x, int y) {
		if (!inRange(x + a - 1, y + b - 1))
			return false;

		int t = sum[x + a - 1][y + b - 1] - sum[x - 1][y + b - 1] - sum[x + a - 1][y - 1] + sum[x - 1][y - 1];

		return t == 0;
	}

	static boolean inRange(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > m)
			return false;
		return true;
	}

	static int bfs() {
		int answer = -1;

		if (!canGo(ex, ey)) {
			return answer;
		}

		boolean[][] v = new boolean[n + 1][m + 1];

		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(sx, sy, 0));

		v[sx][sy] = true;

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == ex && now.y == ey) {
				answer = now.d;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || !canGo(nx, ny) || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny, now.d + 1));
			}
		}

		return answer;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int x, y;

		sum = new int[n + 1][m + 1];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			sum[x][y] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sum[i][j] += (sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1]);
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());

		System.out.println(bfs());

	}
}