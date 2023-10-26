import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static int n;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] map;
	static int[][][] v;
	static final int INF = 1_000_000_007;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static class Node implements Comparable<Node> {
		int x, y, d;

		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Node node) {
			return this.d - node.d;
		}

	}

	static int bfs(int sx, int sy, int ex, int ey) {
		PriorityQueue<Node> q = new PriorityQueue<>();

		v[sx][sy][0] = 0;
		v[sx][sy][1] = 0;
		v[sx][sy][2] = 0;
		v[sx][sy][3] = 0;

		q.add(new Node(sx, sy, 0));
		q.add(new Node(sx, sy, 1));
		q.add(new Node(sx, sy, 2));
		q.add(new Node(sx, sy, 3));

		Node now;
		int nx, ny, nd;

		while (!q.isEmpty()) {
			now = q.poll();
			for (int i = 0; i < 4; i++) {
				if ((now.d == 0 && i == 1) || (now.d == 1 && i == 0)) {
					continue;
				} else if ((now.d == 2 && i == 3) || (now.d == 3 && i == 2)) {
					continue;
				}

				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 'x')
					continue;
				nd = v[now.x][now.y][now.d] + (i == now.d ? 0 : 1);

				if (v[nx][ny][i] <= nd)
					continue;
				v[nx][ny][i] = nd;
				q.add(new Node(nx, ny, i));
			}
		}

		int answer = INF;

		for (int i = 0; i < 4; i++) {
			answer = Math.min(answer, v[ex][ey][i]);
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new char[n][];
		v = new int[n][n][4];

		int sx = -1, sy = -1, ex = -1, ey = -1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();

			for (int j = 0; j < n; j++) {
				Arrays.fill(v[i][j], INF);
				if (map[i][j] == 'A') {
					sx = i;
					sy = j;
				} else if (map[i][j] == 'B') {
					ex = i;
					ey = j;
				}
			}
		}

		System.out.println(bfs(sx, sy, ex, ey));
	}
}