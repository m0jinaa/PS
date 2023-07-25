import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[][] board;
	static boolean[][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static LinkedList<Node> q;
	static LinkedList<Node> list;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= 10)
			return false;
		return true;
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static boolean bfs(int x, int y) {
		q.clear();
		list.clear();

		q.add(new Node(x, y));
		v[x][y] = true;
		int c = board[x][y];
		Node now;
		int nx, ny;
		while (!q.isEmpty()) {
			now = q.poll();
			list.add(now);
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || board[nx][ny] != c || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));

			}
		}

		if (list.size() >= k) {
			for (Node node : list) {
				board[node.x][node.y] = 0;
			}

			return true;
		} else {
			return false;
		}
	}

	static void gravity() {
		int c;
		for (int j = 0; j < 10; j++) {
			c = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (board[i][j] == 0) {
					c++;
				} else if (c != 0) {

					board[i + c][j] = board[i][j];
					board[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		board = new int[n][10];
		q = new LinkedList<>();
		list = new LinkedList<>();

		v = new boolean[n][10];

		char[] arr;
		for (int i = 0; i < n; i++) {
			arr = br.readLine().toCharArray();
			for (int j = 0; j < 10; j++) {
				board[i][j] = arr[j] - '0';
			}
		}

		int cnt = 0;

		while (true) {
			cnt = 0;
			for (int i = 0; i < n; i++) {
				Arrays.fill(v[i], false);
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 10; j++) {
					if (board[i][j] == 0 || v[i][j])
						continue;
					if (bfs(i, j)) {
						cnt++;
					}
				}
			}

			if (cnt == 0)
				break;
			else {
				gravity();
			}
		}

		for (int[] row : board) {
			for (int x : row) {
				sb.append(x);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}