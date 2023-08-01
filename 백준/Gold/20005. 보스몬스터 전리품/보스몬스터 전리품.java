import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, boss;
	static int ex, ey;
	static char[][] map;
	static LinkedList<Loc> q;
	static boolean[][][] v;
	static int damage;
	static int[] damages;

	static class Loc {
		int i, x, y;

		public Loc(int i, int x, int y) {
			super();
			this.i = i;
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs() {

		int[] dx = new int[] { 0, 0, 1, -1 };
		int[] dy = new int[] { 1, -1, 0, 0 };

		int nx, ny;
		Loc now;
		int qsize;
		int answer = 0;

		while (!q.isEmpty() && boss > 0) {

			qsize = q.size();

			while (qsize-- > 0) {

				now = q.poll();

				if (now.x == ex && now.y == ey) {
					damage += damages[now.i];
					answer++;
					continue;
				}

				for (int i = 0; i < 4; i++) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];

					if (!inRange(nx, ny) || map[nx][ny] == 'X' || v[now.i][nx][ny])
						continue;

					v[now.i][nx][ny] = true;

					q.add(new Loc(now.i, nx, ny));
				}

			}

			boss -= damage;
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		damages = new int[26];
		q = new LinkedList<>();

		map = new char[n][];
		v = new boolean[26][n][m];
		int ind;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();

			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'B') {
					ex = i;
					ey = j;
				} else if (map[i][j] != 'X' && map[i][j] != '.') {
					ind = map[i][j] - 'a';
					map[i][j] = '.';
					v[ind][i][j] = true;

					q.add(new Loc(ind, i, j));
				}

			}
		}

		int d;

		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			ind = st.nextToken().charAt(0) - 'a';
			d = Integer.parseInt(st.nextToken());

			damages[ind] = d;
		}

		boss = Integer.parseInt(br.readLine());

		System.out.println(bfs());
	}
}