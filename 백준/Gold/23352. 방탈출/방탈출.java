import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static LinkedList<Node> q;
	static int maxD = -1;
	static int max = 0;

	static class Node {
		int x, y, d;

		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static void bfs(int x, int y) {
		int nx, ny, c;

		q.clear();

		for (int i = 0; i < n; i++) {
			Arrays.fill(v[i], false);
		}

		q.add(new Node(x, y, 0));
		v[x][y] = true;

		Node now;
		while (!q.isEmpty()) {
			now = q.poll();
			c = 0;
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[nx][ny] == 0 || v[nx][ny])
					continue;
				v[nx][ny] = true;
				c++;
				q.add(new Node(nx, ny, now.d + 1));
			}

			if (c == 0) {
				if (now.d == maxD)
					max = Math.max(map[x][y] + map[now.x][now.y], max);
				else if (maxD < now.d) {
					max = map[x][y] + map[now.x][now.y];
					maxD = now.d;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m];
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					continue;
				bfs(i, j);
			}
		}

		System.out.println(max);
	}
}