import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
	static char[][] map;
	static boolean[][] v;
	static LinkedList<Node> q;

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

		int cnt = 1;

		q.add(new Node(x, y));
		v[x][y] = true;

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[nx][ny] == '*' || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new boolean[n][m];
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int answer = 0;

		int cnt;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '*' || v[i][j])
					continue;
				cnt = bfs(i, j);

				answer = Math.max(cnt, answer);
			}
		}

		System.out.println(answer);
	}
}