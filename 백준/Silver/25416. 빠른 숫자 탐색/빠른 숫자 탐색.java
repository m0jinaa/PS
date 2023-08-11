import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= 5 || y < 0 || y >= 5)
			return false;
		return true;
	}

	static class Node {
		int x, y, d;

		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static int bfs(int x, int y) {
		LinkedList<Node> q = new LinkedList<>();
		int answer = -1;

		int nx, ny;
		Node now;

		q.add(new Node(x, y, 0));
		v[x][y] = true;
		while (!q.isEmpty()) {
			now = q.poll();

			if (map[now.x][now.y] == 1) {
				answer = now.d;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == -1 || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny, now.d + 1));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[5][5];
		v = new boolean[5][5];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		System.out.println(bfs(x, y));
	}
}