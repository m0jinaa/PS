import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] v;

	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static LinkedList<Node> q;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= 102 || y < 0 || y >= 102)
			return false;
		return true;
	}

	static int bfs() {
		int answer = 0;

		q.add(new Node(0, 0));
		v[0][0] = true;

		int nx, ny;
		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny))
					continue;
				if (map[nx][ny] == 1)
					answer++;
				else if (!v[nx][ny]) {
					v[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		map = new int[102][102];
		v = new boolean[102][102];
		q = new LinkedList<>();

		int x, y;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			map[x][y] = 1;

		}

		System.out.println(bfs());
	}
}