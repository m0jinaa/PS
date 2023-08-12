import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int[] dr = new int[] { 0, 0, 1, -1 };
	static int[] dc = new int[] { 1, -1, 0, 0 };
	static boolean[][] v;
	static char[][] map;

	static LinkedList<Node> q;

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

		int nc, nr;
		Node now;
		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (map[now.x][now.y] == 'G') {
				answer = now.d;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nr = now.x + dr[i];
				nc = now.y + dc[i];

				if (!inRange(nr, nc) || map[nr][nc] == 'X' || v[nr][nc])
					continue;
				v[nr][nc] = true;
				q.add(new Node(nr, nc, now.d + 1));

			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int cnt;

		q = new LinkedList<>();

		while (tc-- > 0) {

			q.clear();

			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			map = new char[r][];
			v = new boolean[r][c];

			for (int i = 0; i < r; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < c; j++) {
					if (map[i][j] == 'S') {
						q.add(new Node(i, j, 0));
						v[i][j] = true;
					}
				}
			}

			cnt = bfs();

			if (cnt == -1) {
				sb.append("No Exit\n");
			} else {
				sb.append("Shortest Path: ").append(cnt).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}