import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
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
		if (x < 0 || x > n + 1 || y < 0 || y > m + 1)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 2][m + 2];
		boolean[][] v = new boolean[n + 2][m + 2];

		char[] row;

		for (int i = 1; i <= n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 1; j <= m; j++) {
				map[i][j] = row[j - 1] - '0';
			}
		}

		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(0, 0));

		v[0][0] = true;

		Node now;
		int nx, ny;

		int answer = 0;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny)) {// 지도를 벗어나는 경우
					continue;
				} else if (map[nx][ny] == 1) {// 육지인 경우
					answer++;
					continue;
				} else if (v[nx][ny]) {// 이미 방문한 곳인 경우
					continue;
				}

				v[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}

		System.out.println(answer);
	}
}