import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	static int h, w, n;
	static char[][] map;
	static boolean[][][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node {
		int x, y, d, t;

		public Node(int x, int y, int d, int t) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.t = t;
		}

	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= h || y < 0 || y >= w)
			return false;
		return true;
	}

	static int bfs(int x, int y) {
		int answer = -1;

		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(x, y, 1, 0));

		v[1][x][y] = true;
		Node now;
		int nx, ny, nd;
		int temp;
		while (!q.isEmpty()) {
			now = q.poll();
			if (now.d == n + 1) {
				answer = now.t;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nd = now.d;
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || v[nd][nx][ny] || map[nx][ny] == 'X')
					continue;
				v[nd][nx][ny] = true;
				if (map[nx][ny] != '.' && map[nx][ny] != 'X') {
					temp = map[nx][ny] - '0';
					if (nd == temp) {
						nd++;
						v[nd][nx][ny] = true;
					}
				}

				q.add(new Node(nx, ny, nd, now.t + 1));

			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new char[h][w];
		v = new boolean[n + 2][h][w];
		int x = 0, y = 0;
		for (int i = 0; i < h; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 'S') {
					map[i][j] = '.';
					x = i;
					y = j;
				}
			}
		}

		System.out.println(bfs(x, y));
	}
}