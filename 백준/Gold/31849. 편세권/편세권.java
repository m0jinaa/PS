import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Loc {
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static class Home extends Loc {
		int p;

		public Home(int x, int y, int p) {
			super(x, y);
			this.p = p;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int[] dx = new int[] { 0, 0, 1, -1 };
		final int[] dy = new int[] { 1, -1, 0, 0 };

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// 지도
		int[][] map = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(map[i], -1);
		}

		// 방 정보 저장
		Home[] homes = new Home[r];

		int x, y, p;

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());

			homes[i] = new Home(x, y, p);
		}

		LinkedList<Loc> q = new LinkedList<>();

		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			map[x][y] = 0;

			q.add(new Loc(x, y));
		}

		Loc now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (nx <= 0 || nx > n || ny <= 0 || ny > m || map[nx][ny] != -1)
					continue;

				map[nx][ny] = map[now.x][now.y] + 1;
				q.add(new Loc(nx, ny));
			}
		}

		int answer = Integer.MAX_VALUE;

		int score;

		for (Home h : homes) {
			score = map[h.x][h.y] * h.p;

			answer = Math.min(answer, score);
		}

		System.out.println(answer);
	}
}