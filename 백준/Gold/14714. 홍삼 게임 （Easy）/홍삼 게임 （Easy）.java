import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, a, b, da, db;
	static int[][][] v;
	static final int INF = 1_000_000_007;

	static class Node {
		int t, x, y;

		public Node(int t, int x, int y) {
			super();
			this.t = t;
			this.x = x;
			this.y = y;
		}
	}

	static int getMin() {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(0, a, b));

		v[0][a][b] = 1;
		v[1][a][b] = 1;

		Node now;

		int left, right;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.t % 2 == 0) {
				left = (now.x - da + n) % n;
				right = (now.x + da) % n;

				if (v[0][left][now.y] == 0) {
					v[0][left][now.y] = now.t + 1;
					q.add(new Node(now.t + 1, left, now.y));
				}

				if (v[0][right][now.y] == 0) {
					v[0][right][now.y] = now.t + 1;
					q.add(new Node(now.t + 1, right, now.y));
				}
			} 
            else {
				left = (now.y - db + n) % n;
				right = (now.y + db) % n;

				if (v[1][now.x][left] == 0) {
					v[1][now.x][left] = now.t + 1;
					q.add(new Node(now.t + 1, now.x, left));
				}

				if (v[1][now.x][right] == 0) {
					v[1][now.x][right] = now.t + 1;
					q.add(new Node(now.t + 1, now.x, right));
				}
			}
		}

		int ret = INF;

		for (int i = 0; i < n; i++) {
			if (v[0][i][i] != 0) {
				ret = Math.min(ret, v[0][i][i]);
			}
			if (v[1][i][i] != 0) {
				ret = Math.min(ret, v[1][i][i]);
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken()) - 1;
		b = Integer.parseInt(st.nextToken()) - 1;
		da = Integer.parseInt(st.nextToken());
		db = Integer.parseInt(st.nextToken());

		v = new int[2][n][n];

		int answer = getMin();

		System.out.println(answer == INF ? "Evil Galazy" : answer);
	}
}