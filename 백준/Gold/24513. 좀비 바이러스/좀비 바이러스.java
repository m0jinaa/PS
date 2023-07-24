import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] cnt;
	static int[][] time;
	static int[][] type;
	static int[][] map;
	static boolean[][] v;
	static LinkedList<Node> q;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node {
		int x, y, c, t;

		public Node(int x, int y, int c, int t) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.t = t;
		}

	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static void bfs() {
		Node now;
		int nx, ny;
		int qsize;

		cnt[1] = cnt[2] = 1;

		while (!q.isEmpty()) {
			qsize = q.size();
			while (qsize-- > 0) {
				now = q.poll();
				if (type[now.x][now.y] == 3)
					continue;
				for (int i = 0; i < 4; i++) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];

					if (!inRange(nx, ny)) // 범위 벗어남
						continue;
					if (map[nx][ny] == -1) // 치료제 있음
						continue;
					if (time[nx][ny] == now.t + 1 && type[nx][ny] != now.c) { // 동시방문
						cnt[type[nx][ny]]--;
						cnt[3]++;
						type[nx][ny] = 3;
					}

					if (v[nx][ny])
						continue;

					v[nx][ny] = true;
					time[nx][ny] = now.t + 1;
					type[nx][ny] = now.c;
					cnt[now.c]++;
					q.add(new Node(nx, ny, now.c, now.t + 1));
				}

			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		type = new int[n][m];
		time = new int[n][m];
		v = new boolean[n][m];
		cnt = new int[4];

		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1 || map[i][j] == 2) {
					q.add(new Node(i, j, map[i][j], 0));
					v[i][j] = true;

				}
			}
		}

		bfs();

		System.out.println(cnt[1] + " " + cnt[2] + " " + cnt[3]);
	}
}