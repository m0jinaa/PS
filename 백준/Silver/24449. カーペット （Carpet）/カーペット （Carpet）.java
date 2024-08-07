import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static boolean[][] v;
	static char[][] map;

	static class Node {
		int x, y, d;

		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs() {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(0, 0, 0));
		v[0][0] = true;

		Node now;
		int nx, ny;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == n - 1 && now.y == m - 1) {
				answer = now.d;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[now.x][now.y] == map[nx][ny] || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny, now.d + 1));
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
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		System.out.println(bfs());
	}
}