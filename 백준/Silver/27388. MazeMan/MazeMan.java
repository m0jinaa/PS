import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static boolean[][] v;
	static LinkedList<Node> q;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

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

	static int bfs(int x, int y) {
		q.clear();

		q.add(new Node(x, y));
		v[x][y] = true;

		Node now;
		int nx, ny;

		int cnt = 0;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[nx][ny] == 'X' || (map[now.x][now.y] == 'D' && map[nx][ny] == 'D')
						|| v[nx][ny])
					continue;

				if (map[nx][ny] == '.')
					cnt++;

				v[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new boolean[n][m];
		q = new LinkedList<>();

		int total = 0;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '.')
					total++;
				else if (map[i][j] != ' ' && map[i][j] != 'X') {
					map[i][j] = 'D';
				}
			}
		}

		int reachable = 0;

		int player = 0;

		int c;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'D' && !v[i][j]) {
					c = bfs(i, j);
					if (c == 0)
						continue;
					reachable += c;
					player++;
				}
			}
		}

		int unreachable = total - reachable;

		sb.append(player).append(" ").append(unreachable);

		System.out.println(sb.toString());
	}
}