import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int n, m;
	static char[][] map;
	static int[][] endurance;

	static class Node {
		int x, y, c;

		public Node(int x, int y, int c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= m);
	}

	static int countBroken(int x, int y) {
		LinkedList<Node> q = new LinkedList<>();

		// 본진은 2만큼 뻗어나감
		q.add(new Node(x, y, 2));

		int cnt = 0;

		Node now;
		int nx, ny;

		// 여진은 1만큼 뻗어나감 주의
		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x;
				ny = now.y;
				for (int j = 0; j < now.c; j++) {
					nx += dx[i];
					ny += dy[i];

					// 격자를 벗어나거나 방파제인 경우
					if (!inRange(nx, ny) || map[nx][ny] == '|')
						break;
					else if (map[nx][ny] == '*' && endurance[nx][ny] != 0) {// 아직 무너지지 않은 내진설계되어있지않은 건물
						endurance[nx][ny]--;
						q.add(new Node(nx, ny, 1));
						cnt++;
					} else if (map[nx][ny] == '#' && endurance[nx][ny] != 0) {// 내진설계가 된 건물
						endurance[nx][ny]--;
						if (endurance[nx][ny] == 0) {
							q.add(new Node(nx, ny, 1));
							cnt++;
						}
					}
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		endurance = new int[n][m];

		// 진원지
		int sx = -1, sy = -1;

		// 전체 건물 수
		int total = 0;

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '@') {
					map[i][j] = '.';
					sx = i;
					sy = j;
				} else if (map[i][j] == '*') {
					endurance[i][j] = 1;
					total++;
				} else if (map[i][j] == '#') {
					endurance[i][j] = 2;
					total++;
				}
			}
		}

		int broken = countBroken(sx, sy);

		sb.append(broken).append(" ").append(total - broken).append("\n");

		System.out.print(sb.toString());
	}
}