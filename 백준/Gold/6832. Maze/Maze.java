import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static LinkedList<Node> q;
	static int[][] map;
	static int[][] v;

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

	static int bfs() {
		q.clear();
		q.add(new Node(0, 0));

		v[0][0] = 1;

		Node now;
		int nx, ny;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == n - 1 && now.y == m - 1) {
				answer = v[now.x][now.y];
				break;
			}

			for (int i = 0; i < 4; i++) {
				if ((map[now.x][now.y] & (1 << i)) == 0)
					continue;
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 0 || v[nx][ny] != 0)
					continue;
				v[nx][ny] = v[now.x][now.y] + 1;
				q.add(new Node(nx, ny));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		char[] row;

		q = new LinkedList<>();

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());

			map = new int[n][m];
			v = new int[n][m];

			for (int i = 0; i < n; i++) {
				row = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					switch (row[j]) {
					case '+':
						map[i][j] = 15;
						break;
					case '|':
						map[i][j] = 12;
						break;
					case '-':
						map[i][j] = 3;
						break;
					}
				}
			}

			sb.append(bfs()).append("\n");
		}

		System.out.print(sb.toString());
	}
}