import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	// 우,좌,하,상
	static boolean[][][] canGo = new boolean[][][] {
			{ { false, false, false, false }, { false, false, false, false }, { false, false, false, false },
					{ false, false, false, false }, { false, false, false, false }, { false, false, false, false } },
			{ { false, false, false, false }, { false, false, false, false }, { false, false, true, false },
					{ false, true, true, false }, { false, true, false, false }, { false, true, true, false } },
			{ { false, false, false, false }, { false, false, false, true }, { false, false, false, false },
					{ false, true, false, false }, { false, true, false, true }, { false, true, false, true } },
			{ { false, false, false, false }, { true, false, false, true }, { true, false, false, false },
					{ false, false, false, false }, { false, false, false, true }, { true, false, false, true } },
			{ { false, false, false, false }, { true, false, false, false }, { true, false, true, false },
					{ false, false, true, false }, { false, false, false, false }, { true, false, true, false } },
			{ { false, false, false, false }, { true, false, false, true }, { true, false, true, false },
					{ false, true, true, false }, { false, true, false, true }, { true, true, true, true } } };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int[][] map;
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

	static void bfs(int x, int y) {
		q.clear();
		q.add(new Node(x, y));
		v[x][y] = true;

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || !canGo[map[now.x][now.y]][map[nx][ny]][i] || v[nx][ny])
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

		int tc = Integer.parseInt(br.readLine());
		char[] row;
		int cnt;

		q = new LinkedList<>();

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			v = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				row = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					map[i][j] = row[j] - 'A';
				}
			}

			cnt = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 0 || v[i][j])
						continue;
					bfs(i, j);
					cnt++;
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());

	}
}