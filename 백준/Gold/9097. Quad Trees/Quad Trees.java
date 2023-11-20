import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static char[][] map;
	static int ind = 0;
	static char[] binary;
	static StringBuilder sb;

	static class Node {
		int sx, sy, l;

		public Node(int sx, int sy, int l) {
			super();
			this.sx = sx;
			this.sy = sy;
			this.l = l;
		}

	}

	static boolean check(int sx, int sy, int l) {
		char type = map[sx][sy];

		for (int i = sx; i < sx + l; i++) {
			for (int j = sy; j < sy + l; j++) {
				if (type != map[i][j]) {
					return false;
				}
			}
		}

		return true;
	}

	static void binaryToHex() {

		int x = 0;
		int t;
		int y;
		t = (ind % 4 + 3) % 4;
		while (x < ind) {
			y = 0;
			while (t >= 0 && x < ind) {
				y = 2 * y + (binary[x] - '0');

				t--;
				x++;
			}
			t = 3;

			sb.append(String.format("%X", y));
		}

	}

	static void getValue() {

		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(0, 0, n));

		int sx, sy, l;
		Node now;
		while (!q.isEmpty()) {
			now = q.poll();
			sx = now.sx;
			sy = now.sy;
			l = now.l;

			if (check(sx, sy, l)) {
				binary[ind++] = '0';
				binary[ind++] = map[sx][sy];
			} else { // 4개로 분할
				binary[ind++] = '1';
				int size = l / 2;

				q.add(new Node(sx, sy, size));
				q.add(new Node(sx, sy + size, size));
				q.add(new Node(sx + size, sy, size));
				q.add(new Node(sx + size, sy + size, size));
			}
		}

		binaryToHex();
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			map = new char[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			ind = 0;
			binary = new char[620000];

			getValue();

			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}