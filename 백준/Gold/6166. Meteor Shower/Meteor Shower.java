import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n = 501;
	static int[][] map;
	static int[][] time;
	static boolean[][] v;
	static final int INF = 1_000_000_007;

	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node {
		int x, y, t;

		public Node(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
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

		Node now;
		int nx, ny, nt;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (map[now.x][now.y] == INF) {
				answer = now.t;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				nt = now.t + 1;

				if (!inRange(nx, ny) || map[nx][ny] <= nt || v[nx][ny])
					continue;

				v[nx][ny] = true;
				q.add(new Node(nx, ny, nt));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int m = Integer.parseInt(br.readLine());

		map = new int[n][n];
		v = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(map[i], INF);
		}

		int x, y, t, nx, ny;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			map[x][y] = Math.min(map[x][y], t);

			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (!inRange(nx, ny))
					continue;
				map[nx][ny] = Math.min(map[nx][ny], t);
			}
		}

		int answer = bfs();

		System.out.println(answer);

	}
}