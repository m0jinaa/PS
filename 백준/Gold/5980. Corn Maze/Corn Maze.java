import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] map;
	static int[][] v;
	static int[][][] transport;

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

		v[x][y] = 0;

		int answer = -1;

		Node now;
		int nx, ny, ind;

		while (!q.isEmpty()) {
			now = q.poll();

			if (map[now.x][now.y] == '=') {
				answer = v[now.x][now.y];
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '#')
					continue;

				if (map[nx][ny] != '.' && map[nx][ny] != '=') {
					ind = map[nx][ny] - 'A';

					if (transport[ind][0][0] == nx && transport[ind][0][1] == ny) {
						nx = transport[ind][1][0];
						ny = transport[ind][1][1];
					} else {
						nx = transport[ind][0][0];
						ny = transport[ind][0][1];
					}
				}

				if (v[nx][ny] != -1)
					continue;

				v[nx][ny] = v[now.x][now.y] + 1;

				q.add(new Node(nx, ny));
			}
		}

		return answer;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new int[n][m];
		transport = new int[26][2][2];

		int x = -1, y = -1, ind;

		for (int i = 0; i < 26; i++) {
			transport[i][0][0] = -1;
		}

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();

			for (int j = 0; j < m; j++) {
				v[i][j] = -1;
				if (map[i][j] == '@') {
					x = i;
					y = j;
					map[i][j] = '.';
				} else if (map[i][j] == '.' || map[i][j] == '=' || map[i][j] == '#') {
					continue;
				} else {
					ind = map[i][j] - 'A';

					if (transport[ind][0][0] == -1) {
						transport[ind][0][0] = i;
						transport[ind][0][1] = j;
					} else {
						transport[ind][1][0] = i;
						transport[ind][1][1] = j;
					}
				}
			}
		}

		System.out.println(bfs(x, y));
	}
}