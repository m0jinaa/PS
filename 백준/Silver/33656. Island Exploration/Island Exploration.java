import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
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
		return !(x < 0 || x >= r || y < 0 || y >= c);
	}

	static int getLandCount(int x, int y) {
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		map[x][y] = '.';

		Node now;
		int nx, ny;
		int cnt = 1;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '.')
					continue;
				cnt++;
				map[nx][ny] = '.';
				q.add(new Node(nx, ny));
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][];

		int sx = -1;
		int sy = -1;

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();

			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'S') {
					map[i][j] = '#';
					sx = i;
					sy = j;
				}
			}
		}

		int answer = getLandCount(sx, sy);

		System.out.println(answer);
	}
}