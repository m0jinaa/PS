import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	static int r = 10;
	static int c = 9;
	static int[][] rx = new int[][] { { -1, -2, -3 }, { -1, -2, -3 }, { 0, -1, -2 }, { 0, 1, 2 }, { 1, 2, 3 },
			{ 1, 2, 3 }, { 0, 1, 2 }, { 0, -1, -2 } };
	static int[][] ry = new int[][] { { 0, -1, -2 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 2, 3 }, { 0, 1, 2 }, { 0, -1, -2 },
			{ -1, -2, -3 }, { -1, -2, -3 } };

	static class Node {
		int x, y, d;

		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	public static boolean inRange(int x, int y) {
		if (x < 0 || x >= r || y < 0 || y >= c)
			return false;
		return true;

	}

	public static int bfs(int r1, int c1, int r2, int c2) {
		int answer = -1;
		boolean[][] v = new boolean[r][c];

		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(r1, c1, 0));

		v[r1][c1] = true;
		Node now;
		int x, y, nx = 0, ny = 0;
		boolean can;

		while (!q.isEmpty()) {
			now = q.poll();
			if (now.x == r2 && now.y == c2) {
				answer = now.d;
				break;
			}
			for (int i = 0; i < 8; i++) {
				can = true;
				for (int j = 0; j < 3; j++) {
					nx = now.x + rx[i][j];
					ny = now.y + ry[i][j];
					if (!inRange(nx, ny) || (j != 2 && nx == r2 && ny == c2) || (j == 2 && v[nx][ny])) {
						can = false;
						break;
					}
				}

				if (can) {
					v[nx][ny] = true;
					q.add(new Node(nx, ny, now.d + 1));
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		System.out.println(bfs(r1, c1, r2, c2));
	}
}