import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n = 8;
	static char[] character = new char[] { ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
	static LinkedList<Node> q;
	static boolean[][] v;
	static int[] dx = new int[] { -1, -1, 1, 1 };
	static int[] dy = new int[] { 1, -1, 1, -1 };

	static class Node {
		int x, y, c;
		String path;

		public Node(int x, int y, int c, String path) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.path = path;
		}

	}

	static boolean inRange(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > n)
			return false;
		return true;
	}

	static String bfs(int sx, int sy, int ex, int ey) {
		q.clear();

		q.add(new Node(sx, sy, 0, "" + character[sx] + " " + sy));
		v[sx][sy] = true;

		int nx, ny;

		Node now;
		String answer = "Impossible";

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == ex && now.y == ey) {
				answer = "" + now.c + " " + now.path;
				break;
			} else if (now.c == 4)
				continue;

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				while (inRange(nx, ny)) {
					if (!v[nx][ny]) {
						v[nx][ny] = true;
						q.add(new Node(nx, ny, now.c + 1, now.path + " " + character[nx] + " " + ny));
					}
					nx += dx[i];
					ny += dy[i];
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int sx, sy, ex, ey;
		int diff;
		v = new boolean[n + 1][n + 1];
		q = new LinkedList<>();

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			sx = st.nextToken().charAt(0) - 'A' + 1;
			sy = Integer.parseInt(st.nextToken());

			ex = st.nextToken().charAt(0) - 'A' + 1;
			ey = Integer.parseInt(st.nextToken());

			diff = Math.abs(sx - ex) + Math.abs(ey - sy);

			if (diff % 2 != 0) {
				sb.append("Impossible\n");
			} else {
				for (int i = 0; i <= n; i++) {
					Arrays.fill(v[i], false);
				}

				sb.append(bfs(sx, sy, ex, ey)).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}