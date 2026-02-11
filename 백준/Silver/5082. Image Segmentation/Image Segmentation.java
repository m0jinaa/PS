import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int h, w, l;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = new int[] { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
	static int[] dy = new int[] { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
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
		return !(x < 0 || x >= h || y < 0 || y >= w);
	}

	static boolean countArea(int x, int y) {
		v[x][y] = true;
		q.add(new Node(x, y));

		Node now;
		int nx, ny;

		int cnt = 1;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 9; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] != map[x][y] || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));
				cnt++;
			}
		}

		return cnt >= l;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int d = (1 << 8);
		q = new LinkedList<>();

		int answer, s, c, b;

		while (true) {

			st = new StringTokenizer(br.readLine(), " ");

			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			if (h == 0 && w == 0 && s == 0 && l == 0)
				break;

			map = new int[h][w];
			v = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < w; j++) {
					c = 0;
					for (int k = 0; k < 3; k++) {
						c *= d;
						b = Integer.parseInt(st.nextToken()) / s;
						c += b;
					}
					map[i][j] = c;
				}
			}

			answer = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (v[i][j])
						continue;
					else if (countArea(i, j)) {
						answer++;
					}
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}