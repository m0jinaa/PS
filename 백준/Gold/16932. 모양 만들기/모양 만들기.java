import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static int[][] visited;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int ind = 1;
	static Map<Integer, Integer> size;

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

	static void bfs(int x, int y) {
		LinkedList<Loc> q = new LinkedList<>();

		q.add(new Loc(x, y));
		visited[x][y] = ind;
		Loc now;
		int nx, ny;
		int cnt = 1;
		while (!q.isEmpty()) {
			now = q.poll();
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 0 || visited[nx][ny] != 0)
					continue;
				visited[nx][ny] = ind;
				cnt++;
				q.add(new Loc(nx, ny));
			}
		}
		size.put(ind++, cnt);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new int[n][m];

		Set<Integer> checked = new HashSet<>();
		size = new HashMap<>();

		LinkedList<Loc> zero = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zero.add(new Loc(i, j));
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] != 0 || map[i][j] == 0)
					continue;
				bfs(i, j);
			}
		}

		int answer = 0;
		int cnt;
		int nx, ny, p;

		for (Loc now : zero) {
			checked.clear();
			cnt = 1;
			
			for (int k = 0; k < 4; k++) {
				nx = now.x + dx[k];
				ny = now.y + dy[k];
				if (!inRange(nx, ny) || map[nx][ny] == 0)
					continue;
				p = visited[nx][ny];

				if (checked.contains(p))
					continue;
				checked.add(p);

				cnt += size.get(p);

			}
			
			answer = Math.max(answer, cnt);
		}

		System.out.println(answer);
	}
}