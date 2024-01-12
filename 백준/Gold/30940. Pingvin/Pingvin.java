import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int sx, sy, sz, ex, ey, ez;
	static int[] dx = new int[] { 0, 0, 0, 0, 1, -1 };
	static int[] dy = new int[] { 0, 0, 1, -1, 0, 0 };
	static int[] dz = new int[] { 1, -1, 0, 0, 0, 0 };

	static char[][][] map;

	static class Node {
		int x, y, z, c;

		public Node(int x, int y, int z, int c) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.c = c;
		}

		public boolean arrive() {
			if (this.x != ex || this.y != ey || this.z != ez)
				return false;
			return true;
		}
	}

	static boolean inRange(int x, int y, int z) {
		if (x < 0 || x >= n || y < 0 || y >= n || z < 0 || z >= n)
			return false;
		return true;
	}

	static int bfs() {
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(sx, sy, sz, 0));
		map[sz][sx][sy] = '1';

		Node now;
		int nx, ny, nz;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.arrive()) {
				answer = now.c;
				break;
			}

			for (int i = 0; i < 6; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				nz = now.z + dz[i];

				if (!inRange(nx, ny, nz) || map[nz][nx][ny] == '1')
					continue;
				map[nz][nx][ny] = '1';
				q.add(new Node(nx, ny, nz, now.c + 1));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;
		sz = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine(), " ");

		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;
		ez = Integer.parseInt(st.nextToken()) - 1;

		map = new char[n][n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = br.readLine().toCharArray();
			}
		}

		int answer = bfs();

		System.out.println(answer);
	}
}