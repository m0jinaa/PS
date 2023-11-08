import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] map;
	static boolean[][][] v;

	static class Node {
		int x, y, d, c;

		public Node(int x, int y, int d, int c) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs(int sx, int sy, int ex, int ey) {
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(sx, sy, -1, 0));
		Arrays.fill(v[sx][sy], true);

		int answer = -1;

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == ex && now.y == ey) {
				answer = now.c;
				break;
			}

			for (int i = 0; i < 4; i++) {
				// 오른쪽 방향으로 꺾기 금지
				if ((now.d == 0 && i == 2) || (now.d == 1 && i == 3) || (now.d == 2 && i == 1)
						|| (now.d == 3 && i == 0))
					continue;

				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '#' || v[nx][ny][i])
					continue;
				v[nx][ny][i] = true;
				q.add(new Node(nx, ny, i, now.c + 1));
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
		v = new boolean[n][m][4];

		int sx = -1, sy = -1, ex = -1, ey = -1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
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

		int answer = bfs(sx, sy, ex, ey);

		System.out.println(answer);
	}
}