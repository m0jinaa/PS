import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dx = new int[] { 1, -1, 0, 0 };
	static int[] dy = new int[] { 0, 0, 1, -1 };
	static long[][] habitant;
	static boolean[][] v;

	static boolean inRange(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > n)
			return false;
		return true;
	}

	static class Node implements Comparable<Node> {
		int x, y;
		long c;

		public Node(int x, int y, long c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}

		@Override
		public int compareTo(Node node) {
			if (this.c < node.c)
				return -1;
			else if (this.c > node.c)
				return 1;
			else
				return 0;
		}

	}

	static long getMin(int a, int b, int c, int d) {

		PriorityQueue<Node> q = new PriorityQueue<>();

		long answer = -1;

		if (habitant[a][b] != -1) {

			q.add(new Node(a, b, habitant[a][b]));

			Node now;
			int nx, ny;
			long nc;

			while (!q.isEmpty()) {
				now = q.poll();
				if (v[now.x][now.y])
					continue;
				if (now.x == c && now.y == d) {
					answer = now.c;
					break;
				}

				v[now.x][now.y] = true;

				for (int i = 0; i < 4; i++) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];

					if (!inRange(nx, ny) || habitant[nx][ny] == -1)
						continue;
					nc = now.c + habitant[nx][ny];

					q.add(new Node(nx, ny, nc));
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		int a, b, c, d;

		st = new StringTokenizer(br.readLine(), " ");

		b = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		habitant = new long[n + 1][n + 1];
		v = new boolean[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				habitant[i][j] = Long.parseLong(st.nextToken());
			}
		}

		long answer = getMin(a, b, c, d);

		System.out.println(answer);
	}
}