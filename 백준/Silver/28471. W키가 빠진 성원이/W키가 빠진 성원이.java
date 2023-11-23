import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n;

	static int[] dx = new int[] { -1, -1, -1, 0, 1, 1, 0 };
	static int[] dy = new int[] { -1, 0, 1, 1, 1, -1, -1 };

	static char[][] map;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static int bfs(int x, int y) {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(x, y));
		int cnt = 0;
		map[x][y] = '#';
		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 7; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '#')
					continue;
				map[nx][ny] = '#';
				q.add(new Node(nx, ny));
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new char[n][];

		int sx = -1, sy = -1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();

			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'F') {
					sx = i;
					sy = j;
					map[i][j] = '.';
				}
			}
		}

		int answer = bfs(sx, sy);

		System.out.println(answer);
	}
}
