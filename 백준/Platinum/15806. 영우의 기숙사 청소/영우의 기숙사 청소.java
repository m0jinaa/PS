import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, k, t;
	static boolean[][][] v;
	static Node[] test;
	static int[] dx = new int[] { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dy = new int[] { -1, 1, 2, 2, 1, -1, -2, -2 };
	static LinkedList<Node> q;

	static class Node {
		int x, y, t;

		public Node(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static boolean shouldClean() {

		Node now;
		int nx, ny, nt;

		while (!q.isEmpty()) {
			now = q.poll();
			nt = (now.t + 1) % 2;

			for (int i = 0; i < 8; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || v[nt][nx][ny] || now.t >= t)
					continue;
				v[nt][nx][ny] = true;
				q.add(new Node(nx, ny, now.t + 1));
			}
		}

		boolean answer = false;

		for (Node node : test) {
			if (v[t % 2][node.x][node.y]) {
				answer = true;
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		v = new boolean[2][n][n];
		q = new LinkedList<>();

		int x, y;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;

			q.add(new Node(x, y, 0));
		}

		test = new Node[k];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;

			test[i] = new Node(x, y);
		}

		System.out.println(shouldClean() ? "YES" : "NO");
	}
}