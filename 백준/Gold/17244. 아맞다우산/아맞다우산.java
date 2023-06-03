import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[][] map;
	static int[][][] v;

	static class Node {
		int x, y, z, d;

		public Node(int x, int y, int z, int d) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.d = d;
		}
	}

	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static final int INF = 100000;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs(int sx, int sy, int ex, int ey) {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(sx, sy, 0, 0));

		Node now;
		int nx, ny, nz;
		int answer = 0;

		while (!q.isEmpty()) {
			now = q.poll();
			if (now.x == ex && now.y == ey && now.z == k - 1) {
				answer = now.d;
				break;
			}
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny))
					continue;
				nz = now.z + (((now.z & map[nx][ny]) == 0) ? map[nx][ny] : 0);
				if (map[nx][ny] == -1 || v[nx][ny][nz] != INF)
					continue;
				v[nx][ny][nz] = now.d + 1;

				q.add(new Node(nx, ny, nz, v[nx][ny][nz]));
			}
		}

		return answer;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new int[n][m][32];
		int ind = 0;
		char x;
		char[] row;
		int sx = 0, sy = 0;
		int ex = 0, ey = 0;

		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				Arrays.fill(v[i][j], INF);
				switch (row[j]) {
				case '#':
					map[i][j] = -1;
					break;
				case 'S':
					sx = i;
					sy = j;
					map[i][j] = 0;
					break;
				case 'X':
					map[i][j] = (int) Math.pow(2, ind++);
					break;
				case '.':
					map[i][j] = 0;
					break;
				case 'E':
					ex = i;
					ey = j;
					map[i][j] = 0;
					break;
				}
			}
		}
		k = (int) Math.pow(2, ind);

		System.out.println(bfs(sx, sy, ex, ey));
	}
}