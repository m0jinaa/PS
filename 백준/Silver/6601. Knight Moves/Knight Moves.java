import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n = 8;
	static int[] dx = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };
	static boolean[][] v;
	static LinkedList<Node> q;

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
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static int bfs(int sx, int sy, int ex, int ey) {
		q.clear();
		for (int i = 0; i < n; i++) {
			Arrays.fill(v[i], false);
		}

		q.add(new Node(sx, sy, 0));

		Node now;
		int nx, ny;

		int answer = -1;

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
				q.add(new Node(nx, ny, now.d + 1));
				v[nx][ny] = true;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String input, start, end;
		int sx, sy, ex, ey;

		v = new boolean[n][n];
		q = new LinkedList<>();

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			st = new StringTokenizer(input, " ");
			start = st.nextToken();
			end = st.nextToken();

			sx = start.charAt(0) - 'a';
			sy = start.charAt(1) - '1';
			ex = end.charAt(0) - 'a';
			ey = end.charAt(1) - '1';

			sb.append("To get from ").append(start).append(" to ").append(end).append(" takes ")
					.append(bfs(sx, sy, ex, ey)).append(" knight moves.\n");
		}

		System.out.print(sb.toString());
	}
}