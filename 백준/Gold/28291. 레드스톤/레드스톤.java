import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static int[][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static LinkedList<Node> q;

	static class Node {
		int x, y, e;

		public Node(int x, int y, int e) {
			super();
			this.x = x;
			this.y = y;
			this.e = e;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static boolean bfs() {
		Node now;
		int nx, ny, ne;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.e == 1 || map[now.x][now.y] == 2)
				continue;

			ne = map[now.x][now.y] == 0 ? now.e : (now.e - 1);

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == -1 || v[nx][ny] != 0)
					continue;

				v[nx][ny] = ne;

				q.add(new Node(nx, ny, ne));
			}
		}

		boolean answer = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					answer &= (v[i][j] > 0);
				}
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

		int k = Integer.parseInt(br.readLine());

		map = new int[n][m];
		v = new int[n][m];
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			Arrays.fill(map[i], -1);
		}

		String block = "redstone_block";
		String dust = "redstone_dust";
		String lamp = "redstone_lamp";

		String type;
		int x, y;

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			type = st.nextToken();
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			if (block.equals(type)) {
				q.add(new Node(x, y, 15));
				v[x][y] = 15;
				map[x][y] = 0;
			} else if (dust.equals(type)) {
				map[x][y] = 1;
			} else if (lamp.equals(type)) {
				map[x][y] = 2;
			}
		}

		System.out.println(bfs() ? "success" : "failed");
	}
}