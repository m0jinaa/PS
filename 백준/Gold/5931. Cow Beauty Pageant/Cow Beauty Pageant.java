import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static LinkedList<Node> q;
	static LinkedList<Node> list;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] map;
	static boolean[][] v, vv;

	static class Node {
		int x, y, d;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.d = 0;
		}

		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static void figureOutTerratory(int x, int y, char r) {
		q.clear();
		q.add(new Node(x, y));
		map[x][y] = r;
		v[x][y] = true;
		int nx, ny;
		Node now;
		while (!q.isEmpty()) {
			now = q.poll();
			if (r == '1') {
				list.add(now);
				vv[now.x][now.y] = true;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[nx][ny] != 'X' || v[nx][ny])
					continue;
				v[nx][ny] = true;
				map[nx][ny] = r;
				q.add(new Node(nx, ny));
			}
		}

	}

	static int shortestPath() {
		int answer = -1;
		int nx, ny;
		Node now;
		while (!list.isEmpty()) {
			now = list.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny))
					continue;
				else if (map[nx][ny] == '2') {
					return answer = now.d;
				}
				else if (map[nx][ny] != '.' || vv[nx][ny])
					continue;
				vv[nx][ny] = true;
				list.add(new Node(nx, ny, now.d + 1));
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new boolean[n][m];
		vv = new boolean[n][m];

		q = new LinkedList<>();
		list = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		char[] number = new char[] { '1', '2' };
		int ind = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'X' && !v[i][j]) {
					figureOutTerratory(i, j, number[ind++]);
				}
			}
		}

		System.out.println(shortestPath());
	}
}