import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[][] map;
	static boolean[][][][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static ArrayList<Pair> pattern;

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static class Node {
		int x, y, d, p, c;

		public Node(int x, int y, int d, int p, int c) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.p = p;
			this.c = c;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs() {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(0, 0, 0, k, 0));
		v[0][0][0][k] = true;

		Node now;
		int nx, ny, nd, nc, np;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == n - 1 && now.y == m - 1 && now.d == 1) {
				answer = now.c;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 1)
					continue;
				nd = map[nx][ny] == 2 ? 1 : now.d;
				nc = now.c + 1;
				np = now.p;
				if (v[nx][ny][nd][np])
					continue;
				v[nx][ny][nd][np] = true;
				q.add(new Node(nx, ny, nd, np, nc));
			}

			if (now.p != 0) {
				for (Pair pair : pattern) {
					nx = now.x + pair.x;
					ny = now.y + pair.y;
					if (!inRange(nx, ny) || map[nx][ny] == 1)
						continue;

					nd = map[nx][ny] == 2 ? 1 : now.d;
					nc = now.c + 1;
					np = now.p - 1;
					if (v[nx][ny][nd][np])
						continue;
					v[nx][ny][nd][np] = true;
					q.add(new Node(nx, ny, nd, np, nc));
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m][2][k + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x, y, t;

		pattern = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				t = Integer.parseInt(st.nextToken());
				if (t != 1)
					continue;
				x = i - 2;
				y = j - 2;
				pattern.add(new Pair(x, y));
			}
		}

		int answer = bfs();

		System.out.println(answer);
	}
}