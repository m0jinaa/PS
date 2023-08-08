import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static LinkedList<Node> q;
	static int[][] map;
	static boolean[][] v;

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

	static void check() {
		int nx, ny;
		Node now;

		while (!q.isEmpty()) {
			now = q.poll();
			if (now.d == 0)
				continue;

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || v[nx][ny])
					continue;
				v[nx][ny] = true;
				map[nx][ny] = 3;
				q.add(new Node(nx, ny, now.d - 1));

			}
		}

	}

	static int bfs(int sx, int sy, int ex, int ey) {
		LinkedList<Node> list = new LinkedList<>();

		list.add(new Node(sx, sy, 0));

		v[sx][sy] = true;

		int nx, ny;

		Node now;
		int answer = -1;

		while (!list.isEmpty()) {
			now = list.poll();

			if (map[now.x][now.y] == 2) {
				answer = now.d;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 1 || map[nx][ny] == 3 || v[nx][ny])
					continue;
				v[nx][ny] = true;
				list.add(new Node(nx, ny, now.d + 1));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		q = new LinkedList<>();

		v = new boolean[n][m];

		int sx = 0, sy = 0, ex = -1, ey = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 3) {
					q.add(new Node(i, j, k));
					v[i][j] = true;
				} else if (map[i][j] == 4) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				}
			}
		}

		check();

		System.out.println(bfs(sx, sy, ex, ey));
	}
}