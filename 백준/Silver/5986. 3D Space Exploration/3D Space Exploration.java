import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n;
	static int[] dx = new int[] { 1, -1, 0, 0, 0, 0 };
	static int[] dy = new int[] { 0, 0, 1, -1, 0, 0 };
	static int[] dz = new int[] { 0, 0, 0, 0, 1, -1 };
	static boolean[][][] v;
	static char[][][] map;
	static LinkedList<Node> q;

	static class Node {
		int x, y, z;

		public Node(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static boolean inRange(int x, int y, int z) {
		if (x < 0 || x >= n || y < 0 || y >= n || z < 0 || z >= n)
			return false;
		return true;
	}

	static void bfs(int x, int y, int z) {

		q.clear();

		q.add(new Node(x, y, z));
		v[x][y][z] = true;

		Node now;
		int nx, ny, nz;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 6; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				nz = now.z + dz[i];

				if (!inRange(nx, ny, nz) || map[nx][ny][nz] == '.' || v[nx][ny][nz])
					continue;
				v[nx][ny][nz] = true;
				q.add(new Node(nx, ny, nz));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		q = new LinkedList<>();

		n = Integer.parseInt(br.readLine());

		map = new char[n][n][];
		v = new boolean[n][n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				map[i][j] = br.readLine().toCharArray();
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (map[i][j][k] == '*' && !v[i][j][k]) {
						bfs(i, j, k);
						answer++;
					}
				}
			}
		}

		System.out.print(answer);
	}
}