import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int sx, sy, size;
	static int[] dx = new int[] { 0, 0, 1, -1, 1, 1 };
	static int[] dy = new int[] { 1, -1, 0, 0, -1, 1 };
	static boolean[][] v;
	static char[][] map;

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
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static void bfs(int x, int y) {
		q.clear();
		q.add(new Node(x, y));
		v[x][y] = true;

		Node now;
		int nx, ny;

		int min = y;
		int max = y;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 6; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] != '*' || v[nx][ny])
					continue;
				v[nx][ny] = true;
				min = Math.min(min, ny);
				max = Math.max(max, ny);

				q.add(new Node(nx, ny));
			}

		}

		int s = (max - min + 1) / 3;
		if (size < s) {
			size = s;
			sx = x;
			sy = min;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new boolean[n][m];

		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		String[] number = new String[] { "**** ** ** ****", "**  *  *  * ***", "**   * * *  ***", "***  * **  ****",
				"  * *** ****  *", "****  **   ****", "*  *  **** ****", "***  * * *  *  ", "**** ***** ****",
				"**** ****  *  *" };

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '*' && !v[i][j]) {
					bfs(i, j);
				}
			}
		}

		String big = "";

		int ex = sx + size * 5;
		int ey = sy + size * 3;

		for (int i = sx; i < ex; i += size) {
			for (int j = sy; j < ey; j += size) {
				big += map[i][j];
			}
		}

		int answer = -1;

		for (int i = 0; i < 10; i++) {
			if (number[i].equals(big)) {
				answer = i;
				break;
			}
		}

		System.out.println(answer);
	}
}