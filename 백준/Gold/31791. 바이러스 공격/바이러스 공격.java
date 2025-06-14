import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static final int[] dx = new int[] { 0, 0, 1, -1 };
	static final int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node {
		int x, y, t;

		public Node(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
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

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int timeLimit = Integer.parseInt(st.nextToken());
		int timeDelay = Integer.parseInt(st.nextToken());
		int virus = Integer.parseInt(st.nextToken());
		int building = Integer.parseInt(st.nextToken());

		LinkedList<Node> roadQ = new LinkedList<>();
		LinkedList<Node> buildingQ = new LinkedList<>();

		char[][] map = new char[n][];
		boolean[][] distributed = new boolean[n][m];
		boolean[][] completed = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				// 바이러스 초기 살포지점 찾기
				if (map[i][j] == '*') {
					roadQ.add(new Node(i, j, 0));
					distributed[i][j] = true;
				}
			}
		}

		Node now;
		int nx, ny, nt;

		while (!roadQ.isEmpty() || !buildingQ.isEmpty()) {
			if (buildingQ.isEmpty())
				now = roadQ.poll();
			else if (roadQ.isEmpty()) {
				now = buildingQ.poll();
			} else if (buildingQ.peek().t < roadQ.peek().t) {
				now = buildingQ.poll();
			} else {
				now = roadQ.poll();
			}

			if (now.t > timeLimit)
				break;

			// 바이러스 점령완료 표시
			completed[now.x][now.y] = true;

			if (now.t == timeLimit) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || distributed[nx][ny])
					continue;
				distributed[nx][ny] = true;

				nt = now.t + 1;

				if (map[nx][ny] == '#') {
					nt += timeDelay;
					buildingQ.add(new Node(nx, ny, nt));
				} else {
					roadQ.add(new Node(nx, ny, nt));
				}
			}
		}

		int c = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (completed[i][j]) {
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