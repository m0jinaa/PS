import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node {
		int x, y, d, p, c;

		public Node(int x, int y, int d, int p, int c) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.p = p;
			this.c = c;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		char[][] map = new char[n][];

		int sx = -1;
		int sy = -1;
		int ex = -1;
		int ey = -1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'S') {
					sx = i;
					sy = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'E') {
					ex = i;
					ey = j;
					map[i][j] = '.';
				}
			}
		}

		// 입력한 명령어 방향정보로 바꾸기
		char[] row = br.readLine().toCharArray();

		int d = row.length;
		int[] dalgu = new int[d];

		for (int i = 0; i < d; i++) {
			switch (row[i]) {
			case 'R':
				dalgu[i] = 0;
				break;
			case 'L':
				dalgu[i] = 1;
				break;
			case 'D':
				dalgu[i] = 2;
				break;
			case 'U':
				dalgu[i] = 3;
				break;
			}
		}

		row = br.readLine().toCharArray();

		int p = row.length;
		int[] ponix = new int[p];

		for (int i = 0; i < p; i++) {
			switch (row[i]) {
			case 'R':
				ponix[i] = 0;
				break;
			case 'L':
				ponix[i] = 1;
				break;
			case 'D':
				ponix[i] = 2;
				break;
			case 'U':
				ponix[i] = 3;
				break;
			}
		}

		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(sx, sy, 0, 0, 0));
		boolean[][][][] v = new boolean[n][n][d + 1][p + 1];

		v[sx][sy][0][0] = true;

		Node now;
		int nx, ny, nd, np, nc;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == ex && now.y == ey) {
				answer = now.c;
				break;
			}
			if (now.d < d) {
				nx = now.x + dx[dalgu[now.d]];
				ny = now.y + dy[dalgu[now.d]];
				nd = now.d + 1;
				np = now.p;
				nc = now.c + 1;

				if (!inRange(nx, ny) || map[nx][ny] == '#') {
					nx = now.x;
					ny = now.y;
				}
				if (!v[nx][ny][nd][np]) {
					v[nx][ny][nd][np] = true;
					q.add(new Node(nx, ny, nd, np, nc));
				}
			}
			if (now.p < p) {
				nx = now.x + dx[ponix[now.p]];
				ny = now.y + dy[ponix[now.p]];
				nd = now.d;
				np = now.p + 1;
				nc = now.c + 1;

				if (!inRange(nx, ny) || map[nx][ny] == '#') {
					nx = now.x;
					ny = now.y;
				}
				if (!v[nx][ny][nd][np]) {
					v[nx][ny][nd][np] = true;
					q.add(new Node(nx, ny, nd, np, nc));
				}
			}
		}

		System.out.println(answer);
	}
}