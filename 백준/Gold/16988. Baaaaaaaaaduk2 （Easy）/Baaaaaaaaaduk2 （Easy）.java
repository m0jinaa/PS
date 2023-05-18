import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static ArrayList<Loc> list;
	static boolean[][] v;
	static int answer = 0;
	static int[] dx = new int[] { 1, -1, 0, 0 }, dy = new int[] { 0, 0, 1, -1 };

	static class Loc {
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int bfs(int x, int y) {
		Queue<Loc> q = new LinkedList<>();
		int cnt = 1;
		boolean empty = false;
		v[x][y] = true;

		q.add(new Loc(x, y));

		Loc now;
		int nx, ny;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (v[nx][ny] || map[nx][ny] == 1)
					continue;
				if (map[nx][ny] == 0) {
					empty = true;
					continue;
				}
				v[nx][ny] = true;
				cnt++;
				q.add(new Loc(nx, ny));
			}
		}

		return empty ? 0 : cnt;
	}

	static void check() {
		for (int i = 0; i <= n+1; i++) {
			Arrays.fill(v[i], false);
		}

		int total = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 2 && !v[i][j]) {
					total += bfs(i, j);
				}
			}
		}
		
		answer = Math.max(answer, total);
	}

	static void combi(int ind, int cnt) {
		if (cnt == 2) {
			check();
		} else if (ind == list.size()) {
			return;
		} else {
			Loc now = list.get(ind);

			// 선택 o
			map[now.x][now.y] = 1;

			combi(ind + 1, cnt + 1);

			map[now.x][now.y] = 0;

			// 선택x
			combi(ind + 1, cnt);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();

		map = new int[n + 2][m + 2];
		v = new boolean[n + 2][m + 2];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(map[i], 1);
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new Loc(i, j));
				}
			}
		}
		Arrays.fill(map[0], 1);
		Arrays.fill(map[n + 1], 1);
		
		combi(0, 0);

		System.out.println(answer);
	}
}