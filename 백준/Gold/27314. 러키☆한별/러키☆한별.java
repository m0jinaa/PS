import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] map;
	static boolean[][][] v;
	static LinkedList<Person> q;

	static class Person {
		int ind; // 0 : 한별, 1~ : 다른 사람
		int x, y; // 위치

		public Person(int ind, int x, int y) {
			super();
			this.ind = ind;
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs(int sx, int sy) {

		q.add(new Person(0, sx, sy));
		v[sx][sy][0] = true;

		Person p;
		int nx, ny;
		int answer = 0;
		int cnt = 0;

		while (!q.isEmpty()) {
			p = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 'X' || v[nx][ny][p.ind])
					continue;

				v[nx][ny][p.ind] = true;

				q.add(new Person(p.ind, nx, ny));

				if (p.ind == 0 && map[nx][ny] == '#') {
					cnt = 0;
					for (int j = 1; j < k; j++) {
						if (v[nx][ny][j])
							cnt++;
					}
					answer = Math.max(answer, cnt);
				}
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

		map = new char[n][];
		v = new boolean[n][m][101];
		q = new LinkedList<>();

		int sx = -1, sy = -1;
		k = 1;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'P') {
					q.add(new Person(k, i, j));
					v[i][j][k++] = true;
					map[i][j] = '.';
				} else if (map[i][j] == 'H') {
					sx = i;
					sy = j;
					map[i][j] = '.';

				}
			}
		}

		int answer = bfs(sx, sy);

		System.out.println(answer);
	}
}