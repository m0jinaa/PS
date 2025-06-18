import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][][] original;
	static int[][][] map;
	static boolean[][][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static LinkedList<Node> q;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int bfs(int t, int x, int y) {
		q.clear();

		q.add(new Node(x, y));
		int type = map[t][x][y];
		map[t][x][y] = 0;
		v[t][x][y] = true;
		int c = 1;

		int nx, ny;
		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[t][nx][ny] != type)
					continue;
				v[t][nx][ny] = true;
				map[t][nx][ny] = 0;
				q.add(new Node(nx, ny));
				c++;
			}
		}

		return c * c;

	}

	static void recovery(int t) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[t][i][j] = original[t][i][j];

			}
		}
	}

	static void gravity(int t) {
		int x;
		for (int j = 0; j < m; j++) {
			x = n - 1;
			for (int i = n - 1; i >= 0; i--) {
				while (x >= 0 && map[t][x][j] == 0) {
					x--;
				}

				if (x < 0) {
					while (i >= 0) {
						original[t + 1][i--][j] = 0;
					}
					break;
				}
				original[t + 1][i][j] = map[t][x][j];
				x--;
			}
		}
	}

	static int getMaxScore(int t) {
		if (t == 3) {
			return 0;
		}

		recovery(t);

		for (int i = 0; i < n; i++) {
			Arrays.fill(v[t][i], false);
		}

		int max = 0;
		int score = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[t][i][j] == 0 || v[t][i][j])
					continue;

				score = bfs(t, i, j);

				// 중력 작용
				gravity(t);

				max = Math.max(max, score + getMaxScore(t + 1));

				recovery(t);
			}
		}

		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		// 복원하기위한 맵 저장
		original = new int[4][n][m];

		// 현재 맵 상태 저장
		map = new int[3][n][m];

		// 방문체크용
		v = new boolean[3][n][m];

		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				original[0][i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = getMaxScore(0);

		System.out.println(answer);
	}
}