import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] parent;
	static int[] cnt;
	static int[][] map;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		cnt[x] += cnt[y];
		cnt[y] = 0;
		parent[y] = x;

	}

	static void makeSet() {
		int nx, ny;
		int[] dx = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dy = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
		int now, target = -1;
		int val;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				now = i * m + j;
				target = -1;
				val = map[i][j];
				for (int k = 0; k < 8; k++) {
					nx = i + dx[k];
					ny = j + dy[k];

					if (!inRange(nx, ny) || map[nx][ny] > val)
						continue;

					val = map[nx][ny];
					target = nx * m + ny;

				}
				if (target != -1)
					union(target, now);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		cnt = new int[n * m];
		parent = new int[n * m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cnt[i * m + j] = 1;
				parent[i * m + j] = i * m + j;
			}
		}

		makeSet();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(cnt[i * m + j]).append(j == m - 1 ? "\n" : " ");
			}
		}

		System.out.print(sb.toString());
	}
}