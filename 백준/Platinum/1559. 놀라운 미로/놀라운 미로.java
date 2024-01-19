import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, all;
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	static int[][] door;
	static int[][] treasure;

	static boolean[][][][] v;
	static LinkedList<Node> q;
	static final int INF = 1_000_000_007;

	static class Node {
		int x, y, t, d, c;

		public Node(int x, int y, int t, int d, int c) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
			this.d = d;
			this.c = c;
		}

	}

	static int bfs() {
		q.clear();
		q.add(new Node(0, 0, 0, 0, 0));
		v[0][0][0][0] = true;

		int answer = INF;

		int nx, ny, nt, nd, nc, dir;
		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == n - 1 && now.y == m - 1 && now.t == all) {
				answer = now.c;
				break;
			}

			// 문 열린 곳으로 가기
			dir = (door[now.x][now.y] + now.c) % 4;
			nx = now.x + dx[dir];
			ny = now.y + dy[dir];
			if (inRange(nx, ny)) {
				if (treasure[nx][ny] != 0)
					nt = now.t | (1 << (treasure[nx][ny] - 1));
				else
					nt = now.t;
				nd = 0;
				nc = now.c + 1;
				if (inRange(nx, ny) && !v[nx][ny][nt][nd]) {
					v[nx][ny][nt][nd] = true;
					q.add(new Node(nx, ny, nt, nd, nc));
				}
			}
			// 현재위치 머무르기

			if (now.d == 3)// 한자리에서 4번 있었을 경우
				continue;

			nx = now.x;
			ny = now.y;
			nt = now.t;
			nd = now.d + 1;
			nc = now.c + 1;
			if (!v[nx][ny][nt][nd]) {
				v[nx][ny][nt][nd] = true;
				q.add(new Node(nx, ny, nt, nd, nc));
			}
		}

		return answer;
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		char[] row;
		q = new LinkedList<>();
		int x, y;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			door = new int[n][m];

			for (int i = 0; i < n; i++) {
				row = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					switch (row[j]) {
					case 'N':
						door[i][j] = 0;
						break;
					case 'E':
						door[i][j] = 1;
						break;
					case 'S':
						door[i][j] = 2;
						break;
					case 'W':
						door[i][j] = 3;
						break;
					}
				}
			}

			int k = Integer.parseInt(br.readLine());
			all = (1 << k) - 1;
			treasure = new int[n][m];

			for (int i = 1; i <= k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken()) - 1;
				y = Integer.parseInt(st.nextToken()) - 1;

				treasure[x][y] = i;
			}

			v = new boolean[n][m][1 << k][4];

			sb.append(bfs()).append("\n");
		}

		System.out.print(sb.toString());

	}
}