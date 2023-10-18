import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int n = 5, m = 1;
	static int[][] v;

	static int[][] map;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[n][n];
		v = new int[n][n];

		LinkedList<Node> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			Arrays.fill(v[i], -1);
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		int r, c;

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		q.add(new Node(r, c));
		v[r][c] = 0;

		Node now;

		int nx, ny;
		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (map[now.x][now.y] == m) {
				answer = v[now.x][now.y];
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny))
					continue;

				if (map[nx][ny] != -1) {
					if (v[nx][ny] == -1) {
						v[nx][ny] = v[now.x][now.y] + 1;
						q.add(new Node(nx, ny));
					}
				} else {
					continue;
				}

				while (map[nx][ny] != 7 && inRange(nx + dx[i], ny + dy[i]) && map[nx + dx[i]][ny + dy[i]] != -1) {
					nx += dx[i];
					ny += dy[i];
				}

				if (v[nx][ny] == -1) {
					v[nx][ny] = v[now.x][now.y] + 1;
					q.add(new Node(nx, ny));
				}
			}
		}

		System.out.println(answer);
	}
}