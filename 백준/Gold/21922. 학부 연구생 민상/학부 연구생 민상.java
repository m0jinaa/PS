import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[][][] v;
	static boolean[][] cnt;
	static int[][] map;
	static LinkedList<Node> q;
	static int[][] dx = new int[][] { { 1, -1, 0, 0 }, { 1, -1, 0, 0 }, { -1, 1, 0, 0 }, { 0, 0, -1, 1 },
			{ 0, 0, 1, -1 } };
	static int[][] dy = new int[][] { { 0, 0, 1, -1 }, { 0, 0, -1, 1 }, { 0, 0, 1, -1 }, { -1, 1, 0, 0 },
			{ 1, -1, 0, 0 } };
	static int[][] dd = new int[][] { { 0, 1, 2, 3 }, { 0, 1, 3, 2 }, { 1, 0, 2, 3 }, { 3, 2, 1, 0 }, { 2, 3, 0, 1 } };

	static class Node {
		int x, y, d;

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

	static int bfs() {
		int canSit = 0;
		Node now;
		int nx, ny, nd;
		while (!q.isEmpty()) {
			now = q.poll();
			nx = now.x + dx[map[now.x][now.y]][now.d];
			ny = now.y + dy[map[now.x][now.y]][now.d];
			nd = dd[map[now.x][now.y]][now.d];

			if (!inRange(nx, ny) || v[nx][ny][nd])
				continue;
			v[nx][ny][nd] = true;
			if (!cnt[nx][ny]) {
				canSit++;
				cnt[nx][ny] = true;
			}
			q.add(new Node(nx, ny, nd));
		}

		return canSit;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m][4];
		cnt = new boolean[n][m];
		q = new LinkedList<>();
		int answer = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					q.add(new Node(i, j, 0));
					q.add(new Node(i, j, 1));
					q.add(new Node(i, j, 2));
					q.add(new Node(i, j, 3));
					answer++;
					map[i][j] = 0;
					Arrays.fill(v[i][j], true);
					cnt[i][j] = true;

				}
			}
		}

		answer += bfs();

		System.out.println(answer);
	}
}