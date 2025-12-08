import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n = 10;
	static char[][] map;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static boolean[][] cleaned;

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
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		cleaned[x][y] = true;

		Node now;

		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] != '-' || cleaned[nx][ny])
					continue;

				cleaned[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		map = new char[n][];
		cleaned = new boolean[n][n];

		int sx = -1;
		int sy = -1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < n && sx == -1; j++) {
				if (map[i][j] == 'B') {
					sx = i;
					sy = j;
					map[i][j] = '-';
				}
			}
		}

		String input;

		int x, y;

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			st = new StringTokenizer(input, "(,)");

			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			// 장애물 표시
			map[x][y] = 'O';
		}

		bfs(sx, sy);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((map[i][j] != '-' && map[i][j] != 'O') || cleaned[i][j])
					continue;

				sb.append("(").append(j).append(",").append(i).append(")\n");
			}
		}

		System.out.print(sb.toString());
	}
}