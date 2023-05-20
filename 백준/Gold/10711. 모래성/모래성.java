import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

	static int[][] map;
	static int[][] empty;
	static boolean[][] visited;
	static int[] dx = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;

		return true;
	}

	static class Loc {
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		empty = new int[n][m];
		visited = new boolean[n][m];

		char[] row;

		LinkedList<Loc> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (row[j] == '.') {
					q.add(new Loc(i, j));
					map[i][j] = 0;
					visited[i][j] = true;

				} else {
					map[i][j] = row[j] - '0';
				}
			}
		}

		int qsize;
		int stage = 0;
		Loc now;

		int nx, ny;
		boolean change;
		while (!q.isEmpty()) {
			qsize = q.size();
			change = false;
			while (qsize-- > 0) {
				now = q.poll();

				for (int i = 0; i < 8; i++) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];

					if (!inRange(nx, ny) || visited[nx][ny])
						continue;
					empty[nx][ny]++;
					if (empty[nx][ny] >= map[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new Loc(nx, ny));
						change = true;
					}
				}
			}
			if(change) {
				stage++;
			}
		}

		System.out.println(stage);
	}
}