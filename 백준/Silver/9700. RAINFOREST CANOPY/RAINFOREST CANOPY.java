import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n;
	static char[][] map;
	static boolean[][] v;
	static int[] dx = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
	static LinkedList<Node> q;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= n);
	}

	static void bfs(int x, int y) {
		q.clear();
		q.add(new Node(x, y));
		v[x][y] = true;

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] != '1' || v[nx][ny])
					continue;
				q.add(new Node(nx, ny));
				v[nx][ny] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input;

		q = new LinkedList<>();

		int answer = 0;

		int tc = 0;

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			tc++;

			n = Integer.parseInt(input);

			map = new char[n][];
			v = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}

			answer = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '0' || v[i][j])
						continue;
					bfs(i, j);
					answer++;
				}
			}

			sb.append("Case #").append(tc).append(": ").append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}