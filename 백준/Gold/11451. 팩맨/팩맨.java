import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static char[][] map;
	static char[] dir = { 'S', 'N', 'E', 'W' };

	public static class PackMan {
		Node a, b;
		String path;
		int c;

		public PackMan(Node a, Node b, String path, int c) {
			this.a = a;
			this.b = b;
			this.path = path;
			this.c = c;
		}
	}

	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static String bfs(Node a, Node b) {
		LinkedList<PackMan> q = new LinkedList<>();

		boolean[][][][] v = new boolean[n][m][n][m];

		q.add(new PackMan(a, b, "", 0));

		String answer = "IMPOSSIBLE";

		while (!q.isEmpty()) {
			PackMan temp = q.poll();

			if (temp.a.x == temp.b.x && temp.a.y == temp.b.y) {
				answer = temp.c + " " + temp.path;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx1 = (temp.a.x + dx[i] + n) % n;
				int ny1 = (temp.a.y + dy[i] + m) % m;
				int nx2 = (temp.b.x + dx[i] + n) % n;
				int ny2 = (temp.b.y + dy[i] + m) % m;

				if (map[nx1][ny1] == 'X') {
					nx1 = temp.a.x;
					ny1 = temp.a.y;
				}

				if (map[nx2][ny2] == 'X') {
					nx2 = temp.b.x;
					ny2 = temp.b.y;
				}

				if (v[nx1][ny1][nx2][ny2] || map[nx1][ny1] == 'G' || map[nx2][ny2] == 'G')
					continue;
				v[nx1][ny1][nx2][ny2] = true;

				q.add(new PackMan(new Node(nx1, ny1), new Node(nx2, ny2), temp.path + dir[i], temp.c + 1));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new char[n][m];

			Node a = null;
			Node b = null;

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();

				for (int j = 0; j < m; j++) {

					if (map[i][j] == 'P') {
						if (a == null)
							a = new Node(i, j);
						else
							b = new Node(i, j);

						map[i][j] = '.';
					}
				}
			}

			sb.append(bfs(a, b)).append("\n");
		}

		System.out.print(sb.toString());
	}
}