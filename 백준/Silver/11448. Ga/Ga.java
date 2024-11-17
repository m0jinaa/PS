import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n;
	static int[] dx = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
	static LinkedList<Node> q;
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
		return !(x < 0 || x >= n || y < 0 || y >= n);
	}

	static int getCnt() {

		Node now;
		int nx, ny;

		int cnt = 0;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] != '-')
					continue;
				map[nx][ny] = 'w';
				q.add(new Node(nx, ny));
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		q = new LinkedList<>();

		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());

			q.clear();

			map = new char[n][];

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 'w')
						continue;
					q.add(new Node(i, j));
				}
			}

			sb.append(getCnt()).append("\n");
		}

		System.out.println(sb.toString());
	}
}