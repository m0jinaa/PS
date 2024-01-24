import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] map;
	static boolean[][][][] v;
	static LinkedList<Node> q;

	static class Node {
		int x, y, d, b, c;

		public Node(int x, int y, int d, int b, int c) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.b = b;
			this.c = c;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs() {
		Node now;
		int nx, ny, nd, nb, nc;
		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (v[now.x][now.y][now.d][3]) {
				answer = now.c;
				break;
			}

			for (int i = 0; i < 4; i++) {
				if (now.d == i)
					continue;
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '#')
					continue;
				nd = i;
				if (map[nx][ny] == '1') {
					nb = now.b | 1;
				} else if (map[nx][ny] == '2') {
					nb = now.b | 2;
				} else {
					nb = now.b;
				}
				nc = now.c + 1;

				if (v[nx][ny][nd][nb])
					continue;
				v[nx][ny][nd][nb] = true;
				q.add(new Node(nx, ny, nd, nb, nc));
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

		map = new char[n][];
		v = new boolean[n][m][4][4];
		q = new LinkedList<>();

		int x = 1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'S') {
					v[i][j][0][0] = true;
					v[i][j][1][0] = true;
					v[i][j][2][0] = true;
					v[i][j][3][0] = true;

					q.add(new Node(i, j, 0, 0, 0));
					q.add(new Node(i, j, 1, 0, 0));
					q.add(new Node(i, j, 2, 0, 0));
					q.add(new Node(i, j, 3, 0, 0));
				} else if (map[i][j] == 'C') {
					if (x == 1) {
						map[i][j] = '1';
					} else {
						map[i][j] = '2';
					}
					x++;
				}
			}
		}

		int answer = bfs();

		System.out.println(answer);
	}
}