import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int[][] map;
	static int[][][] v;
	static LinkedList<Person> q;

	static class Person {
		int ind, x, y, t;

		public Person(int ind, int x, int y, int t) {
			super();
			this.ind = ind;
			this.x = x;
			this.y = y;
			this.t = t;
		}

	}

	static boolean inRange(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > n)
			return false;
		return true;
	}

	static void bfs() {
		int answer = -1;
		Person p;
		int nx, ny;
		while (!q.isEmpty()) {
			p = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 1 || v[p.ind][nx][ny] != -1)
					continue;
				v[p.ind][nx][ny] = p.t + 1;

				q.add(new Person(p.ind, nx, ny, p.t + 1));
			}
		}

		int cnt = 0;
		int d;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 1 || v[0][i][j] == -1 || v[1][i][j] == -1 || v[2][i][j] == -1)
					continue;
				d = Math.max(v[0][i][j], Math.max(v[1][i][j], v[2][i][j]));
				if (d == answer) {
					cnt++;
				} else if (answer == -1 || d < answer) {
					answer = d;
					cnt = 1;
				}
			}
		}

		if (answer == -1) {
			System.out.println(answer);
		} else {
			System.out.println(answer + "\n" + cnt);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		v = new int[3][n + 1][m + 1];

		q = new LinkedList<>();

		char[] row;

		for (int i = 1; i <= n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 1; j <= m; j++) {
				map[i][j] = row[j - 1] - '0';
				v[0][i][j] = -1;
				v[1][i][j] = -1;
				v[2][i][j] = -1;
			}
		}

		int x, y;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			v[i][x][y] = 0;
			q.add(new Person(i, x, y, 0));
		}

		bfs();
	}
}