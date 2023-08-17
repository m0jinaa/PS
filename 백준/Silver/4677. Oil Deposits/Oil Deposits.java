import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	static int n, m;
	static int[] dx = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
	static LinkedList<Node> q;
	static boolean[][] v;
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
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static void bfs(int x, int y) {
		q.clear();

		int nx, ny;

		v[x][y] = true;

		Node now;

		q.add(new Node(x, y));

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '*' || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		int cnt;
		q = new LinkedList<>();

		while (true) {

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			map = new char[n][];
			v = new boolean[n][m];

			cnt = 0;

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
                    if (map[i][j] == '*' || v[i][j])
                        continue;
                    bfs(i, j);
                    cnt++;
				}
			}

			sb.append(cnt).append("\n");
		}
        System.out.print(sb.toString());
	}
}