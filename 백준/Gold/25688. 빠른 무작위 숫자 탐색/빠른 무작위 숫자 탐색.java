import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int n = 5, m = 6;
	static int[][][] v;

	static int[][] map;

	static class Node {
		int x, y, z;

		public Node(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[n][n];
		v = new int[n][n][1 << (m + 1)];

		LinkedList<Node> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(v[i][j], -1);
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		int r, c;

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		q.add(new Node(r, c, 1));
		v[r][c][1] = 0;

		Node now;

		int nx, ny, nz;
		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.z == (1 << (m + 1)) - 1) {
				answer = v[now.x][now.y][now.z];
				break;
			}
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[nx][ny] == -1)
					continue;
				nz = now.z | (1 << map[nx][ny]);

				if (v[nx][ny][nz] != -1)
					continue;
				v[nx][ny][nz] = v[now.x][now.y][now.z] + 1;
				q.add(new Node(nx, ny, nz));
			}
		}

		System.out.println(answer);
	}
}