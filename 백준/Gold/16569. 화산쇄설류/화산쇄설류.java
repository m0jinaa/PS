import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int m, n;
	static ArrayList<Node>[] volcano;
	static int[][] map;
	static boolean[][] visited;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n)
			return false;
		return true;
	}

	static void bfs(int x, int y) {
		LinkedList<Node> q = new LinkedList<>();
		LinkedList<Node> vol = new LinkedList<>();
		int answerH = map[x][y];
		int answerT = 0;
		int[] dx = new int[] { 0, 0, 1, -1 };
		int[] dy = new int[] { 1, -1, 0, 0 };

		q.add(new Node(x, y));

		visited[x][y] = true;

		int nx, ny;
		Node now;
		int t = 0;
		int qsize;
		int vsize;

		while (!q.isEmpty()) {
			if (t <= 200) {
				for (Node node : volcano[t]) {
					vol.add(node);
				}
			}

			vsize = vol.size();
			qsize = q.size();

			while (vsize-- > 0) {
				now = vol.poll();

				for (int i = 0; i < 4; i++) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];

					if (!inRange(nx, ny) || visited[nx][ny])
						continue;
					visited[nx][ny] = true;
					vol.add(new Node(nx, ny));
				}
			}

			while (qsize-- > 0) {
				now = q.poll();

				for (int i = 0; i < 4; i++) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];

					if (!inRange(nx, ny) || map[nx][ny] == -1 || visited[nx][ny])
						continue;
					visited[nx][ny] = true;
					if (answerH < map[nx][ny]) {
						answerH = map[nx][ny];
						answerT = t + 1;
					}
					q.add(new Node(nx, ny));
				}
			}
			t++;
		}
		System.out.println(answerH + " " + answerT);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		volcano = new ArrayList[201];
		map = new int[m][n];
		visited = new boolean[m][n];

		for (int i = 0; i <= 200; i++) {
			volcano[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine(), " ");

		int sx = Integer.parseInt(st.nextToken()) - 1;
		int sy = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x, y, t;
		while (v-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = -1;
			t = Integer.parseInt(st.nextToken());

			volcano[t].add(new Node(x, y));
		}

		bfs(sx, sy);

	}
}