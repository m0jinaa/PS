import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int[] dx, dy;
	static LinkedList<Node> q;
	static int[][] map;
	static int n;
	static boolean[][] v;

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
		if (x < 0 || x >= r || y < 0 || y >= c)
			return false;
		return true;
	}

	static int bfs() {
		int nx, ny;
		Node now;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();
			if (now.x == r - 1) {
				answer = now.d;
				break;
			}

			for (int i = 0; i < n; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 0 || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny, now.d + 1));

			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		q = new LinkedList<>();

		v = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0 && map[i][j] == 1) {
					q.add(new Node(i, j, 0));
					v[i][j] = true;
				}
			}
		}

		n = Integer.parseInt(br.readLine());

		dx = new int[n];
		dy = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			dx[i] = Integer.parseInt(st.nextToken());
			dy[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(bfs());
	}
}