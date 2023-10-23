import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] v;
	static int[][] state;
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

	static void bfs() {
		q.clear();

		q.add(new Node(0, 0));
		v[0][0] = 1;

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				if ((state[now.x][now.y] & (1 << i)) != 0)
					continue;
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || v[nx][ny] != 0)
					continue;
				v[nx][ny] = v[now.x][now.y] + 1;

				q.add(new Node(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		q = new LinkedList<>();

		int x;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			state = new int[n][m];
			v = new int[n][m];

			// input
			for (int i = 0; i < n; i++) {
				// wall on the right side
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j < m; j++) {
					x = Integer.parseInt(st.nextToken());
					if (x == 0)
						continue;
					state[i][j] += 2;
					state[i][j - 1] += 1;
				}

				// wall on the bottom
				if (i == n - 1)
					continue;

				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < m; j++) {
					x = Integer.parseInt(st.nextToken());

					if (x == 0)
						continue;

					state[i][j] += 4;
					state[i + 1][j] += 8;
				}
			}

			// get Answer
			bfs();

			// output
			sb.append(v[n - 1][m - 1]).append("\n");
		}

		System.out.print(sb.toString());

	}
}