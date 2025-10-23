import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static int[][] dp;
	static int[][] map;

	static LinkedList<Node> queue;

	static boolean inRange(int x, int y) {
		return !(x <= 0 || x > n || y <= 0 || y > m);
	}

	static void checkBoundary(int x, int y) {
		queue.add(new Node(x, y));
		dp[x][y] = 0;

		Node now;
		int nx, ny;

		while (!queue.isEmpty()) {
			now = queue.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 1 || dp[nx][ny] == 0)
					continue;
				dp[nx][ny] = 0;
				queue.add(new Node(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		dp = new int[n + 1][m + 1];
		queue = new LinkedList<>();

		char[] row;

		for (int i = 1; i <= n; i++) {
			row = br.readLine().toCharArray();

			for (int j = 1; j <= m; j++) {
				map[i][j] = row[j - 1] - '0';
				dp[i][j] = 1;
			}
		}

		// 테두리에 도달할 수 있는 칸 체크
		checkBoundary(1, 1);

		// 누적합으로 건물 칸 세기
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
			}
		}

		int r1, c1, r2, c2;
		int cnt;

		int q = Integer.parseInt(br.readLine());

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			r1 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());

			cnt = dp[r2][c2] - dp[r2][c1 - 1] - dp[r1 - 1][c2] + dp[r1 - 1][c1 - 1];

			if (cnt == 0) {
				sb.append("Yes\n");
			} else {
				sb.append("No ").append(cnt).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}