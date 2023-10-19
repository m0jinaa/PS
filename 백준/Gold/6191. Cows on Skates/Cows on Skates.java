import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] map;
	static int[][] v;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static void bfs() {

		LinkedList<Node> q = new LinkedList<>();
		v[0][0] = 0;

		q.add(new Node(0, 0));

		int nx, ny;
		Node now;

		while (!q.isEmpty()) {
			now = q.poll();
			if (now.x == n - 1 && now.y == m - 1)
				break;

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '*' || v[nx][ny] != -1)
					continue;

				v[nx][ny] = v[now.x][now.y] + 1;

				q.add(new Node(nx, ny));
			}
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new int[n][m];

		for (int i = 0; i < n; i++) {
			Arrays.fill(v[i], -1);
			map[i] = br.readLine().toCharArray();
		}

		bfs();

		Stack<Node> stack = new Stack<>();

		int x = n - 1;
		int y = m - 1;

		int nx, ny;

		while (x != 0 || y != 0) {
			stack.push(new Node(x + 1, y + 1));
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];

				if (!inRange(nx, ny) || v[nx][ny] != v[x][y] - 1)
					continue;
				x = nx;
				y = ny;
				break;
			}
		}
		sb.append("1 1\n");

		Node now;

		while (!stack.isEmpty()) {
			now = stack.pop();
			sb.append(now.x).append(" ").append(now.y).append("\n");
		}

		System.out.println(sb.toString());
	}
}