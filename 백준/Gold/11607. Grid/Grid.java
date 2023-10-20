import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static class Node {
		int x, y, d;

		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
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

			if (now.x == n - 1 && now.y == m - 1) {
				answer = now.d;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i] * map[now.x][now.y];
				ny = now.y + dy[i] * map[now.x][now.y];

				if (!inRange(nx, ny) || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny, now.d + 1));
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

		map = new int[n][m];
		v = new boolean[n][m];
		char[] row;
		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = row[j] - '0';
			}
		}

		int answer = bfs();

		System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
	}
}