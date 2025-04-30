import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static int[][][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static LinkedList<Node> q;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= m);
	}

	static void move(int sx, int sy, int ind) {

		q.clear();

		q.add(new Node(sx, sy));

		v[sx][sy][ind] = 0;

		Node now;

		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '#' || v[nx][ny][ind] != -1)
					continue;

				v[nx][ny][ind] = v[now.x][now.y][ind] + 1;
				q.add(new Node(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		q = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		v = new int[n][m][2]; // 0일 때 -> 진우가 움직였을 때, 1일때 -> 승찬이가 움직였을 때
		map = new char[n][];

		int sx = -1, sy = -1, ex = -1, ey = -1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();

			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'J') {
					sx = i;
					sy = j;
				} else if (map[i][j] == 'S') {
					ex = i;
					ey = j;
				}
				Arrays.fill(v[i][j], -1);
			}
		}

		int answer;

		int jToS, jToT, tToS;

		move(sx, sy, 0);
		move(ex, ey, 1);

		jToS = v[ex][ey][0];

		if (jToS == -1) {
			answer = -1;
		} else {

			answer = jToS * 2;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 'T')
						continue;
					jToT = v[i][j][0];
					tToS = v[i][j][1];

					if (jToT == -1 || tToS == -1) {
						continue;
					}

					answer = Math.min(answer, jToT * 2 + tToS);
				}
			}
		}

		System.out.println(answer);
	}
}