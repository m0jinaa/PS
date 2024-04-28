import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dx = new int[] { 1, 1, -1, -1 };
	static int[] dy = new int[] { 1, -1, 1, -1 };
	static int[][] xy;

	static boolean[][][] v;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static class Node {
		int x, y, t;

		public Node(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	static int bfs() {
		LinkedList<Node> q = new LinkedList<>();

		int cnt = 1;

		q.add(new Node(0, 0, 0));
		q.add(new Node(0, 0, 1));
		v[0][0][0] = true;
		v[0][0][1] = true;

		Node now;
		int nx, ny;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i] * xy[now.t][0];
				ny = now.y + dy[i] * xy[now.t][1];

				if (!inRange(nx, ny) || v[nx][ny][now.t])
					continue;
				v[nx][ny][now.t] = true;

				if (!v[nx][ny][1 - now.t])
					cnt++;
				q.add(new Node(nx, ny, 1 - now.t));
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i] * xy[now.t][1];
				ny = now.y + dy[i] * xy[now.t][0];

				if (!inRange(nx, ny) || v[nx][ny][now.t])
					continue;
				v[nx][ny][now.t] = true;

				if (!v[nx][ny][1 - now.t])
					cnt++;

				q.add(new Node(nx, ny, 1 - now.t));
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		xy = new int[2][2];

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 2; j++) {
				xy[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		v = new boolean[n][n][2];

		int answer = bfs();

		System.out.println(answer);
	}
}