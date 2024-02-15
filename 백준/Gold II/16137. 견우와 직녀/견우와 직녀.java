import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int[][] map;

	static class Node {
		int x, y, d, t;

		public Node(int x, int y, int d, int t) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.t = t;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static void check() {
		boolean horizontal = false;
		boolean vertical = false;

		int nx, ny;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				horizontal = false;
				vertical = false;

				if (map[i][j] != 0)
					continue;

				for (int k = 0; k < 2; k++) {
					nx = i + dx[k];
					ny = j + dy[k];
					if (!inRange(nx, ny) || map[nx][ny] == 1)
						continue;
					horizontal = true;
					break;
				}

				for (int k = 2; k < 4; k++) {
					nx = i + dx[k];
					ny = j + dy[k];
					if (!inRange(nx, ny) || map[nx][ny] == 1)
						continue;
					vertical = true;
					break;
				}

				if (horizontal && vertical) {
					map[i][j] = -1;
				}
			}
		}
	}

	static int bfs() {
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0, 0));
		boolean[][][] v = new boolean[2][n][n];
		v[0][0][0] = true;

		int answer = -1;

		Node now;
		int nx, ny, nd;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == n - 1 && now.y == n - 1) {
				answer = now.t;
				break;
			}

			// 현재자리에 머무르기
			if (map[now.x][now.y] == 1) {
				q.add(new Node(now.x, now.y, now.d, now.t + 1));
			}

			// 움직이기
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == -1)
					continue;

				nd = map[nx][ny] == 0 ? 1 : now.d;

				if (v[nd][nx][ny])
					continue;

				if (map[nx][ny] == 1) {
					v[nd][nx][ny] = true;
					q.add(new Node(nx, ny, now.d, now.t + 1));
				} else if (map[now.x][now.y] == 1 && map[nx][ny] == 0 && now.d == 0) {
					if ((now.t + 1) % m != 0)
						continue;
					nd = 1;
					v[nd][nx][ny] = true;
					q.add(new Node(nx, ny, 1, now.t + 1));
				} else if (map[now.x][now.y] == 1 && map[nx][ny] != 0) {
					if ((now.t + 1) % map[nx][ny] != 0)
						continue;

					v[nd][nx][ny] = true;
					q.add(new Node(nx, ny, now.d, now.t + 1));
				}
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

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check();

		int answer = bfs();

		System.out.println(answer);
	}
}