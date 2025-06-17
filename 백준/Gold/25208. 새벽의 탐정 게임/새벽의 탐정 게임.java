import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node {
		int x, y, p, t;

		public Node(int x, int y, int p, int t) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
			this.t = t;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		char[][] map = new char[n][];
		boolean[][][] v = new boolean[n][m][6];

		LinkedList<Node> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'D') {
					q.add(new Node(i, j, 0, 0));
					v[i][j][0] = true;
					map[i][j] = '.';
				}
			}
		}

		Node now;
		int nx, ny, np = -1;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (map[now.x][now.y] == 'R') {
				if (now.p == 0) {
					answer = now.t;
					break;
				}
				continue;
			}

			for (int i = 0; i < 4; i++) {
				// i => 0:남쪽, 1:북쪽, 2:동쪽, 3:서쪽
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				// 격자를 벗어나거나 벽인 경우
				if (!inRange(nx, ny) || map[nx][ny] == '#')
					continue;

				// 감옥의 형태(뚫린방향)
				// 0:아래쪽, 1:동쪽, 2:서쪽, 3:남쪽, 4:북쪽, 5:위쪽

				if (i == 0) {
					switch (now.p) {
					case 0:
						np = 4;
						break;
					case 1:
					case 2:
						np = now.p;
						break;
					case 3:
						np = 0;
						break;
					case 4:
						np = 5;
						break;
					case 5:
						np = 3;
						break;
					}
				} else if (i == 1) {
					switch (now.p) {
					case 0:
						np = 3;
						break;
					case 1:
					case 2:
						np = now.p;
						break;
					case 3:
						np = 5;
						break;
					case 4:
						np = 0;
						break;
					case 5:
						np = 4;
						break;
					}
				} else if (i == 2) {
					switch (now.p) {
					case 0:
						np = 2;
						break;
					case 3:
					case 4:
						np = now.p;
						break;
					case 1:
						np = 0;
						break;
					case 2:
						np = 5;
						break;
					case 5:
						np = 1;
						break;
					}
				} else {
					switch (now.p) {
					case 0:
						np = 1;
						break;
					case 3:
					case 4:
						np = now.p;
						break;
					case 1:
						np = 5;
						break;
					case 2:
						np = 0;
						break;
					case 5:
						np = 2;
						break;
					}
				}

				if (v[nx][ny][np])
					continue;
				v[nx][ny][np] = true;
				q.add(new Node(nx, ny, np, now.t + 1));
			}
		}

		System.out.println(answer);
	}
}