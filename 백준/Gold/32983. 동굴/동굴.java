import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] v;
	static int[] earn;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node {
		int x, y, c;

		public Node(int x, int y, int c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= m);
	}

	static void move(int x, int y) {

		int nx, ny;

		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(x, y, 0));
		v[x][y] = true;

		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			earn[now.c] += map[now.x][now.y];

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == -1 || v[nx][ny])
					continue;
				v[nx][ny] = true;

				q.add(new Node(nx, ny, now.c + 1));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int sx = Integer.parseInt(st.nextToken()) - 1;
		int sy = Integer.parseInt(st.nextToken()) - 1;

		map = new int[n][m];
		v = new boolean[n][m];
		earn = new int[n * m + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		move(sx, sy);

		int answer = earn[0];

		for (int i = 1; i <= n * m; i++) {
			earn[i] += earn[i - 1];
			answer = Math.max(answer, earn[i] - c * i);
		}

		System.out.println(answer);
	}
}