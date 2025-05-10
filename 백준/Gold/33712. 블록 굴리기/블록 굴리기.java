import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[][] map;
	static boolean[][][][] v;
	static int[][] dx = new int[][] { { -2, 0, 1, 0 }, { -1, 0, 1, 0 }, { -1, 0, 2, 0 } };
	static int[][] dy = new int[][] { { 0, 1, 0, -2 }, { 0, 2, 0, -1 }, { 0, 1, 0, -1 } };
	static int[][] ds = new int[][] { { 2, 1, 2, 1 }, { 1, 0, 1, 0 }, { 0, 2, 0, 2 } };

	static class Node {
		int x, y, c, s;

		public Node(int x, int y, int c, int s) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.s = s;
		}
	}

	// (x,y)지점에 s형태로 놓일 수 있는지 확인
	// s==0 : 세워진 상태 => .
	// s==1 : 가로로 눞혀진 상태 => ㅡ
	// s==2 : 세로로 눞혀진 상태 => ㅣ
	static boolean canPlace(int x, int y, int s) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		else if (map[x][y] == 0)
			return false;
		else if (s == 1 && (y + 1 >= m || map[x][y + 1] == 0))
			return false;
		else if (s == 2 && (x + 1 >= n || map[x + 1][y] == 0))
			return false;

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		v = new boolean[n][m][k + 1][3];
		map = new int[n][m];

		int sx = -1;
		int sy = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					sx = i;
					sy = j;
				}
			}
		}

		// (x,y)지점에 s의 형태로 놓여있고 현재까지 c번 움직였을 때 목표지점에 k번만에 도달할 수 있는 곳 표시
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(sx, sy, 0, 0));
		v[sx][sy][0][0] = true;

		Node now;
		int nx, ny, nc, ns;

		while (!q.isEmpty()) {
			now = q.poll();

			// k번 움직인 경우 더 움직일 수 없음
			if (now.c == k)
				continue;

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[now.s][i];
				ny = now.y + dy[now.s][i];
				nc = now.c + 1;
				ns = ds[now.s][i];

				if (!canPlace(nx, ny, ns) || v[nx][ny][nc][ns])
					continue;

				v[nx][ny][nc][ns] = true;

				q.add(new Node(nx, ny, nc, ns));
			}
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 1 || !v[i][j][k][0])
					continue;
				answer++;
			}
		}

		System.out.println(answer);
	}
}