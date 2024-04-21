import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static boolean[][] v;
	static LinkedList<Node> q;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node {
		int x, y;

		public Node(int x, int y) {
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

	public static int bfs(int x, int y) {
		q.clear();

		q.add(new Node(x, y));
		v[x][y] = true;

		Node now;
		int nx, ny;

		int ret = 1;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '#' || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));
				ret++;
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int cnt, answer;

		q = new LinkedList<>();

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new char[n][];
			v = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}

			answer = 0;
			cnt = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == '#' || v[i][j])
						continue;
					answer += bfs(i, j);
					cnt++;
				}
			}

			sb.append(cnt).append(cnt == 1 ? " section, " : " sections, ").append(answer)
					.append(answer == 1 ? " space\n" : " spaces\n");
		}

		System.out.print(sb.toString());
	}
}