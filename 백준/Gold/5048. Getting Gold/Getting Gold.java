import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static boolean[][] v;

	static boolean canMove(int x, int y) {
		int cnt = 0;

		int nx, ny;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (!inRange(nx, ny) || map[nx][ny] != 'T')
				cnt++;
		}

		return cnt == 4;
	}

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

	static int bfs(int x, int y) {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(x, y));

		v[x][y] = true;
		int answer = 0;

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			if (!canMove(now.x, now.y))
				continue;
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[nx][ny] == '#' || v[nx][ny])
					continue;
				if (map[nx][ny] == 'G')
					answer++;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));

			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		int x = -1;
		int y = -1;

		map = new char[n][];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'P') {
					x = i;
					y = j;
					break;
				}
			}
		}

		System.out.println(bfs(x, y));
	}
}