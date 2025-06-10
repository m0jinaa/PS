import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, c, cx, cy;
	static int[][] map;
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

	static int checkOne() {

		if (map[cx][cy] == 0)
			return 0;

		// 초기화
		q.clear();
		for (int i = 0; i < n; i++) {
			Arrays.fill(v[i], false);
		}

		q.add(new Node(cx, cy));
		v[cx][cy] = true;

		int cnt = 1;

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 0 || v[nx][ny])
					continue;

				cnt++;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));

			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m];
		q = new LinkedList<>();

		char[] row;

		c = 0;
		cx = 0;
		cy = 0;

		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();

			for (int j = 0; j < m; j++) {
				map[i][j] = row[j] - '0';

				if (map[i][j] != 0) {
					cx = i;
					cy = j;
					c++;
				}
			}
		}

		int day = 0;
		int d;
		int sx, sy, ex, ey;

		int[][] nextMap = new int[n][m];

		// 곰팡이가 하나로 합쳐졌는지 확인
		while (checkOne() != c) {
			day++;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					// 곰팡이가 없는 곳이거나 해당날에 번진 곳이면 패스
					if (map[i][j] == 0)
						continue;

					// 얼마만큼 속도로 번져야하는가
					d = map[i][j];

					sx = Math.max(0, i - d);
					ex = Math.min(n - 1, i + d);
					sy = Math.max(0, j - d);
					ey = Math.min(m - 1, j + d);

					for (int x = sx; x <= ex; x++) {
						for (int y = sy; y <= ey; y++) {
							// 번지는 속도 저장
							nextMap[x][y] = Math.max(nextMap[x][y], d);
						}
					}
				}
			}

			// 곰팡이수 다시 세면서 다음 격자판 형태 구하기
			c = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = Math.max(map[i][j], nextMap[i][j]);
					if (map[i][j] != 0)
						c++;
				}
			}
		}

		System.out.println(day);
	}
}