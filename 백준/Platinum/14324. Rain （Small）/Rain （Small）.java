import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int[][] map;
	static boolean[][] v;
	static PriorityQueue<Node> q;

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
			return this.h - node.h;
		}
	}

	public static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	public static int getWater() {

		q.clear();

		for (int i = 0; i < n; i++) {
			q.add(new Node(i, 0, map[i][0]));
			q.add(new Node(i, m - 1, map[i][m - 1]));

			v[i][0] = true;
			v[i][m - 1] = true;
		}
		for (int i = 1; i < m - 1; i++) {
			q.add(new Node(0, i, map[0][i]));
			q.add(new Node(n - 1, i, map[n - 1][i]));

			v[0][i] = true;
			v[n - 1][i] = true;
		}

		int nx, ny, nh;
		int answer = 0;

		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			answer += (now.h - map[now.x][now.y]);

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || v[nx][ny])
					continue;

				nh = Math.max(now.h, map[nx][ny]);
				v[nx][ny] = true;
				q.add(new Node(nx, ny, nh));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		q = new PriorityQueue<>();

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			v = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("Case #").append(t).append(": ").append(getWater()).append("\n");
		}

		System.out.print(sb.toString());
	}
}