import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int x, y, d, c;

		public Node(int x, int y, int d, int c) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}

		@Override
		public int compareTo(Node node) {
			return this.c - node.c;
		}
	}

	static final int INF = 1_000_000_007;
	static int n, m, t;
	static int[][][] v;
	static char[][] map;
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, -1, 0, 1 };

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= m);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new int[n][m][4];

		int sx = -1;
		int sy = -1;
		int sd = -1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				Arrays.fill(v[i][j], INF);
				if (map[i][j] >= '0' && map[i][j] <= '3') {
					sx = i;
					sy = j;
					sd = map[i][j] - '0';
					map[i][j] = '.';
				}
			}
		}

		PriorityQueue<Node> q = new PriorityQueue<>();

		v[sx][sy][sd] = 0;
		q.add(new Node(sx, sy, sd, 0));

		Node now;
		int nx, ny, nd, nc;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (v[now.x][now.y][now.d] < now.c)
				continue;

			if (map[now.x][now.y] == 'S') { // 바다 도착
				answer = now.c;
				break;
			} else if (map[now.x][now.y] == 'T') {// 수돗물
				nd = (now.d + 1) % 4;
				nx = now.x + dx[nd];
				ny = now.y + dy[nd];

				if (!inRange(nx, ny) || v[nx][ny][nd] <= now.c)
					continue;
				v[nx][ny][nd] = now.c;
				q.add(new Node(nx, ny, nd, now.c));
			} else {
				// 바라보는 방향의 수직한 방향으로 이동
				for (int i = 1; i <= 3; i += 2) {
					nx = now.x + dx[(now.d + i) % 4];
					ny = now.y + dy[(now.d + i) % 4];
					nd = now.d;
					nc = now.c + 1;
					if (inRange(nx, ny) && v[nx][ny][nd] > nc) {
						v[nx][ny][nd] = nc;
						q.add(new Node(nx, ny, nd, nc));
					}
				}

				// 방향 전환
				nx = now.x;
				ny = now.y;
				nd = (now.d + 1) % 4;
				nc = now.c + t;
				if (v[nx][ny][nd] > nc) {
					v[nx][ny][nd] = nc;
					q.add(new Node(nx, ny, nd, nc));
				}
			}
		}

		System.out.println(answer);
	}
}