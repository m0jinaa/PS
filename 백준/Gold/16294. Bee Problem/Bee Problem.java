import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static boolean[][] v;
	static int[] dx = new int[] { -1, -1, 0, 1, 1, 0 };
	static int[] dy = new int[] { -1, 1, 2, 1, -1, -2 };
	static LinkedList<Node> q;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m || (x % 2 == 0 && y > m - 1))
			return false;
		return true;
	}

	static int bfs(int x, int y) {
		q.clear();

		q.add(new Node(x, y));
		v[x][y] = true;
		int cnt = 1;

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 6; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] != '.' || v[nx][ny])
					continue;

				v[nx][ny] = true;
				q.add(new Node(nx, ny));
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int h = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()) * 2;

		map = new char[n][];
		v = new boolean[n][m];
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; (i % 2 == 0 && j < m - 1) || (i % 2 == 1 && j < m); j++) {
				if (map[i][j] == '.' && !v[i][j]) {
					list.add(bfs(i, j));
				}
			}
		}

		Collections.sort(list, Collections.reverseOrder());
		int cnt = 0;
		while (h > 0) {
			cnt++;
			h -= list.poll();
		}
		System.out.println(cnt);
	}
}