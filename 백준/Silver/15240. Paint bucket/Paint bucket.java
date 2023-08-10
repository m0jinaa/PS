import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] map;
	static boolean[][] v;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static void bfs(int x, int y, char c) {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(x, y));
		char t = map[x][y];
		map[x][y] = c;
		v[x][y] = true;

		int nx, ny;

		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] != t || v[nx][ny])
					continue;
				v[nx][ny] = true;
				map[nx][ny] = c;
				q.add(new Node(nx, ny));

			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		st = new StringTokenizer(br.readLine(), " ");

		int x, y;
		char k;

		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = st.nextToken().charAt(0);

		bfs(x, y, k);

		for (int i = 0; i < n; i++) {
			sb.append(String.valueOf(map[i])).append("\n");
		}

		System.out.println(sb.toString());
	}
}