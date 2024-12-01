import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

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
		if (x <= 0 || x > n || y <= 0 || y > m)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int ex = Integer.parseInt(st.nextToken());
		int ey = Integer.parseInt(st.nextToken());

		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(1, 1, 0));

		int answer = -1;

		boolean[][] v = new boolean[n + 1][m + 1];

		Node now;
		int nx, ny;

		int[] dx = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] dy = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == ex && now.y == ey) {
				answer = now.d;
				break;
			}

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || v[nx][ny])
					continue;

				v[nx][ny] = true;
				q.add(new Node(nx, ny, now.d + 1));
			}
		}

		System.out.println(answer == -1 ? "NEVAR" : answer);
	}
}