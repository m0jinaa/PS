import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n = 5;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int[][] map;
	static boolean[][][] v;

	static class Node {
		int x, y, d, c;

		public Node(int x, int y, int d, int c) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static int bfs(int x, int y) {
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(x, y, 0, 0));

		v[x][y][0] = true;

		Node now;
		int nx, ny, nd;
		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.d == 6) {
				answer = now.c;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == -1)
					continue;

				nd = now.d + (map[nx][ny] == now.d + 1 ? 1 : 0);

				if (!v[nx][ny][nd]) {
					v[nx][ny][nd] = true;
					q.add(new Node(nx, ny, nd, now.c + 1));
				}

				while (map[nx][ny] != 7 && inRange(nx + dx[i], ny + dy[i]) && map[nx + dx[i]][ny + dy[i]] != -1) {
					nx += dx[i];
					ny += dy[i];
				}

				nd = now.d + (map[nx][ny] == now.d + 1 ? 1 : 0);

				if (v[nx][ny][nd])
					continue;
				v[nx][ny][nd] = true;
				q.add(new Node(nx, ny, nd, now.c + 1));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[n][n];

		v = new boolean[n][n][7];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int answer = bfs(x, y);

		System.out.println(answer);
	}
}