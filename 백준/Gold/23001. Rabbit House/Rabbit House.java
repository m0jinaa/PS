import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] v;

	static class Node implements Comparable<Node> {
		int x, y, h;

		public Node(int x, int y, int h) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;
		}

		@Override
		public int compareTo(Node node) {
			return node.h - this.h;
		}
	}

	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		PriorityQueue<Node> pq = new PriorityQueue<>();

		Node now;
		int nx, ny;
		long answer;
		int d;
		for (int t = 1; t <= tc; t++) {

			answer = 0;

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			v = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					pq.add(new Node(i, j, map[i][j]));
				}
			}

			while (!pq.isEmpty()) {
				now = pq.poll();

				if (map[now.x][now.y] != now.h)
					continue;

				for (int i = 0; i < 4; i++) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];

					if (!inRange(nx, ny) || v[nx][ny])
						continue;
					v[nx][ny] = true;

					d = now.h - map[nx][ny];

					if (d > 1) {
						answer += d - 1;
						pq.add(new Node(nx, ny, now.h - 1));
						map[nx][ny] = now.h - 1;
					} else {
						pq.add(new Node(nx, ny, map[nx][ny]));
					}
				}
			}
			sb.append("Case #").append(t).append(": ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}