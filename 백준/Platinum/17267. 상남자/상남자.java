import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static int[][] v;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	static class Node {
		int x, y, l, r;

		public Node(int x, int y, int l, int r) {
			super();
			this.x = x;
			this.y = y;
			this.l = l;
			this.r = r;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs(int x, int y, int l, int r) {
		Queue<Node> q = new LinkedList<>();

		q.add(new Node(x, y, l, r));
		v[x][y] = l + r;
		Node now;
		int nx, ny, nl, nr;

		int cnt = 1;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {// 좌우
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 1)
					continue;

				nl = now.l - (i == 2 ? 1 : 0);
				nr = now.r - (i == 3 ? 1 : 0);

				if (nl < 0 || nr < 0)
					continue;

				if (v[nx][ny] >= nr + nl)
					continue;

				if (v[nx][ny] == -1)
					cnt++;
				v[nx][ny] = nl + nr;
				q.add(new Node(nx, ny, nl, nr));
			}

		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new int[n][m];
		int sx = -1, sy = -1;
		char[] row;
		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				v[i][j] = -1;
				map[i][j] = row[j] - '0';
				if (map[i][j] == 2) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				}
			}
		}

		int answer = bfs(sx, sy, l, r);

		System.out.println(answer);
	}
}