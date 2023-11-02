import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, ind;
	static int[] dx = new int[] { 2, -2, 2, -2, 1, 1, -1, -1 };
	static int[] dy = new int[] { 1, 1, -1, -1, 2, -2, 2, -2 };
	static int[][][] v;
	static LinkedList<Node> q;
	static final int INF = 1_000_000_007;

	static class Node {
		int ind, x, y, d, c;

		public Node(int ind, int x, int y, int d, int c) {
			super();
			this.ind = ind;
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs() {

		Node now, p;
		int nx, ny;

		LinkedList<Node> list = new LinkedList<>();
		int lsize;
		while (!q.isEmpty()) {
			now = q.poll();

			list.clear();
			list.add(now);

			for (int k = 0; k < now.d; k++) {
				lsize = list.size();
				while (lsize-- > 0) {
					p = list.poll();

					for (int i = 0; i < 8; i++) {
						nx = p.x + dx[i];
						ny = p.y + dy[i];
						if (!inRange(nx, ny) || v[nx][ny][p.ind] <= now.c + 1)
							continue;
						v[nx][ny][p.ind] = now.c + 1;
						q.add(new Node(p.ind, nx, ny, p.d, now.c + 1));
						list.add(new Node(p.ind, nx, ny, p.d, now.c));
					}
				}
			}
		}
		int answer = INF;
		int total;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				total = 0;
				for (int k = 0; k < ind; k++) {
					if (v[i][j][k] == INF) {
						total = INF;
						break;
					}
					total += v[i][j][k];
				}
				answer = Math.min(answer, total);
			}
		}

		return answer;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		v = new int[n][m][100];

		ind = 0;

		q = new LinkedList<>();

		char[] row;
		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				Arrays.fill(v[i][j], INF);

				if (row[j] == '.')
					continue;
				v[i][j][ind] = 0;
				q.add(new Node(ind++, i, j, row[j] - '0', 0));
			}
		}

		int answer = bfs();

		System.out.println(answer == INF ? -1 : answer);
	}
}