import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n, m;
	static boolean[][] v;
	static LinkedList<Node> q;
	static char[][] map;
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
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs() {

		int nx, ny;
		Node now;
		int answer = n * m + 1;
		while (!q.isEmpty()) {
			now = q.poll();

			if (now.y == m - 1) {
				answer = now.c;
				break;
			}
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '#' || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny, now.c - 1));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = 2;
		m = Integer.parseInt(br.readLine());

		v = new boolean[n][m];
		map = new char[n][];

		q = new LinkedList<>();

		int total = n * m;
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] != '.')
					total--;
			}
		}

		for (int i = 0; i < n; i++) {
			if (map[i][0] == '.') {
				q.add(new Node(i, 0, total - 1));
				v[i][0] = true;
			}
		}

		System.out.println(bfs());
	}
}