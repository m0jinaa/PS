import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static final int[] dx = new int[] { 0, 0, 1, -1 };
	static final int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node implements Comparable<Node> {
		int x, y, t;

		public Node(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}

		@Override
		public int compareTo(Node node) {
			return this.t - node.t;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int timeLimit = Integer.parseInt(st.nextToken());
		int timeDelay = Integer.parseInt(st.nextToken());
		int virus = Integer.parseInt(st.nextToken());
		int building = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> q = new PriorityQueue<>();

		char[][] map = new char[n][];
		int[][] completed = new int[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				completed[i][j] = INF;
				// 바이러스 초기 살포지점 찾기
				if (map[i][j] == '*') {
					q.add(new Node(i, j, 0));
					completed[i][j] = 0;
				}
			}
		}

		Node now;
		int nx, ny, nt;

		int qsize;

		for (int t = 0; t <= timeLimit; t++) {
			qsize = q.size();
			// queue의 맨 첫번째 요소의 점령시간이 현재시간보다 작거나 같을 경우에만 가능
			while (qsize-- > 0 && q.peek().t <= t) {
				now = q.poll();

				for (int i = 0; i < 4; i++) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];

					if (!inRange(nx, ny) || completed[nx][ny] != INF)
						continue;
					nt = now.t + 1;

					if (map[nx][ny] == '#')
						nt += timeDelay;

					completed[nx][ny] = nt;
					q.add(new Node(nx, ny, nt));
				}
			}
		}

		int c = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (completed[i][j] <= timeLimit) {
					continue;
				}
				sb.append(i + 1).append(" ").append(j + 1).append("\n");
				c++;
			}
		}

		if (c == 0) {
			sb.append(-1);
		}
		System.out.print(sb.toString());
	}
}