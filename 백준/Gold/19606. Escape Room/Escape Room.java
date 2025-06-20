import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > m)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		int[][] map = new int[n + 1][m + 1];
		boolean[][] v = new boolean[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(1, 1));
		v[1][1] = true;

		Node now;
		int nx, ny;

		int x, limit;

		boolean possible = false;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == n && now.y == m) {
				possible = true;
				break;
			}

			x = map[now.x][now.y];

			limit = (int) Math.floor(Math.sqrt(x));

			// 약수 찾아서 갈 수 있는 곳 찾기
			for (int i = 1; i <= limit; i++) {
				if (x % i != 0)
					continue;
				nx = i;
				ny = x / i;

				if (inRange(nx, ny) && !v[nx][ny]) {
					v[nx][ny] = true;
					q.add(new Node(nx, ny));
				}

				if (inRange(ny, nx) && !v[ny][nx]) {
					v[ny][nx] = true;
					q.add(new Node(ny, nx));
				}
			}
		}

		System.out.println(possible ? "yes" : "no");
	}
}