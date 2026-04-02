import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_007;

	static int n, m, total;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static char[][] map;
	static boolean[][] v;
	static LinkedList<Node> q;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= m);
	}

	static int getMinTime(int sx1, int sy1, int sx2, int sy2) {
		v = new boolean[n][m];
		v[sx1][sy1] = true;
		v[sx2][sy2] = true;

		q.clear();
		q.add(new Node(sx1, sy1));
		q.add(new Node(sx2, sy2));

		int c = 0;
		int time = 0;

		int qsize;

		Node now;
		int nx, ny;

		while (c != total) {
			qsize = q.size();
			time++;
			while (qsize-- > 0) {
				now = q.poll();

				for (int i = 0; i < 4; i++) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];

					if (!inRange(nx, ny) || v[nx][ny])
						continue;
					if (map[nx][ny] == '1') {
						c++;
					}

					v[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}

		return time;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		q = new LinkedList<>();

		total = 0;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '1') {
					total++;
				}
			}
		}

		int answer = INF;

		for (int sx1 = 0; sx1 < n; sx1++) {
			for (int sy1 = 0; sy1 < m; sy1++) {
				if (map[sx1][sy1] == '1')
					continue;
				for (int sx2 = sx1; sx2 < n; sx2++) {
					for (int sy2 = 0; sy2 < m; sy2++) {
						if (sx1 == sx2 && sy1 == sy2)
							continue;
						else if (map[sx2][sy2] == '1')
							continue;

						answer = Math.min(answer, getMinTime(sx1, sy1, sx2, sy2));
					}
				}
			}
		}

		System.out.println(answer);
	}
}