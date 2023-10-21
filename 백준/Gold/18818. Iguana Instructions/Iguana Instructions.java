import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] map;
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
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static int bfs() {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(0, 0, 0));
		v[0][0] = true;

		int answer = -1;

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == n - 1 && now.y == n - 1) {
				answer = now.d;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				while (inRange(nx, ny) && map[nx][ny] != '#') {
					if (v[nx][ny]) {
						nx += dx[i];
						ny += dy[i];
						continue;
					}
					v[nx][ny] = true;
					q.add(new Node(nx, ny, now.d + 1));
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new char[n][];
		v = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int answer = bfs();

		System.out.println(answer);
	}
}