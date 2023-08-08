import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int[] dxx = new int[] { 1, 1, -1, -1 };
	static int[] dyy = new int[] { 1, -1, 1, -1 };
	static LinkedList<Node> q;
	static int[][] map;
	static boolean[][] v;

	static class Node {
		int x, y, d;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

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
			int j;
			for (int i = 0; i <= now.d; i++) {
				j = now.d - i;

				for (int k = 0; k < 4; k++) {
					nx = now.x + i * dxx[k];
					ny = now.y + j * dyy[k];
					if (!inRange(nx, ny))
						continue;
					map[nx][ny] = 1;
				}
			}
		}
	}

	static int bfs() {
		LinkedList<Node> list = new LinkedList<>();

		list.add(new Node(0, 0, 0));

		v[0][0] = true;

		int nx, ny;

		Node now;
		int answer = -1;

		while (!list.isEmpty()) {
			now = list.poll();

			if (now.x == n - 1 && now.y == m - 1) {
				answer = now.d;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 1 || v[nx][ny])
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

		map = new int[n][m];
		q = new LinkedList<>();

		v = new boolean[n][m];

		int k = Integer.parseInt(br.readLine());

		int x, y, d;
		
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			d = Integer.parseInt(st.nextToken());

			q.add(new Node(x, y, d));
			v[x][y] = true;
		}

		check();

		int answer = bfs();

		System.out.println(answer == -1 ? "NO" : "YES\n" + answer);
	}
}