import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Loc {
		int x, y;

		public Loc(int x, int y) {
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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		boolean[][] v = new boolean[n][m];
		char[] row;
		LinkedList<Loc> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (row[j] == 'I') {
					q.add(new Loc(i, j));
					v[i][j] = true;
					map[i][j] = 0;
				} else if (row[j] == 'O') {
					map[i][j] = 0;
				} else if (row[j] == 'P') {
					map[i][j] = 1;
				} else {
					map[i][j] = -1;
				}
			}
		}

		Loc now;
		int nx, ny;
		int answer = 0;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[nx][ny] == -1 || v[nx][ny]) {
					continue;
				}
				answer += map[nx][ny];
				v[nx][ny] = true;
				q.add(new Loc(nx, ny));
			}
		}
		
		System.out.println(answer==0?"TT":answer);
	}
}