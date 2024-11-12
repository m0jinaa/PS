import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int h, w, x;
	static int[][] map;
	static boolean[][] v;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean check() {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(0, 0));
		v[0][0] = true;

		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] != map[0][0] || v[i][j] || Math.abs(i - now.x) + Math.abs(j - now.y) > x)
						continue;

					v[i][j] = true;
					q.add(new Node(i, j));
				}
			}
		}

		return v[h - 1][w - 1];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		h = Integer.parseInt(br.readLine());
		w = Integer.parseInt(br.readLine());

		map = new int[h][w];
		v = new boolean[h][w];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		x = Integer.parseInt(br.readLine());

		System.out.println(check() ? "ALIVE" : "DEAD");
	}
}