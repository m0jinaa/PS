import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][][][] v;// v[x좌표][y좌표][몇번까지차례로방문했는지][현재말의종류]

	static int[][] dx = new int[][] { { -2, -2, -1, 1, 2, 2, 1, -1 }, { 1, 1, -1, -1 }, { 0, 0, 1, -1 } };
	static int[][] dy = new int[][] { { -1, 1, 2, 2, 1, -1, -2, -2 }, { 1, -1, 1, -1 }, { 1, -1, 0, 0 } };

	static class Node {
		int x, y, t, s, d;

		public Node(int x, int y, int t, int s, int d) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
			this.s = s;
			this.d = d;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static int bfs(int x, int y) {
		LinkedList<Node> q = new LinkedList<>();
		for (int i = 0; i < 3; i++) {
			q.add(new Node(x, y, 1, i, 0));
			v[x][y][1][i] = true;
		}

		Node now;
		int nx, ny, nt;
		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();
			if (now.t == n * n) {
				answer = now.d;
				break;
			}

			for (int i = 0; i < 3; i++) { // 말 바꾸기
				if (v[now.x][now.y][now.t][i])
					continue;
				v[now.x][now.y][now.t][i] = true;

				q.add(new Node(now.x, now.y, now.t, i, now.d + 1));

			}
			if (now.s == 0) {// 나이트
				for (int i = 0; i < 8; i++) {
					nx = now.x + dx[now.s][i];
					ny = now.y + dy[now.s][i];
					if (!inRange(nx, ny))
						continue;
					nt = now.t + (map[nx][ny] == now.t + 1 ? 1 : 0);

					if (v[nx][ny][nt][now.s])
						continue;

					v[nx][ny][nt][now.s] = true;
					q.add(new Node(nx, ny, nt, now.s, now.d + 1));
				}
			} else {// 비숍,룩
				for (int i = 0; i < 4; i++) {
					nx = now.x + dx[now.s][i];
					ny = now.y + dy[now.s][i];
					while (inRange(nx, ny)) {
						nt = now.t + (map[nx][ny] == now.t + 1 ? 1 : 0);

						if (!v[nx][ny][nt][now.s]) {
							v[nx][ny][nt][now.s] = true;
							q.add(new Node(nx, ny, nt, now.s, now.d + 1));
						}
						nx += dx[now.s][i];
						ny += dy[now.s][i];
					}
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		v = new boolean[n][n][n * n + 1][3];

		int sx = -1, sy = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					sx = i;
					sy = j;
				}
			}
		}

		int answer = bfs(sx, sy);

		System.out.println(answer);
	}
}