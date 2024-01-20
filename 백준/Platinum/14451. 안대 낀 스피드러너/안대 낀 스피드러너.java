import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n;
	static char[][] map;
	static boolean[][][][][][] v;

	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n | y < 0 || y >= n)
			return false;
		return true;
	}

	static class Node {
		int x1, y1, d1, x2, y2, d2, c;

		public Node(int x1, int y1, int d1, int x2, int y2, int d2, int c) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.d1 = d1;
			this.x2 = x2;
			this.y2 = y2;
			this.d2 = d2;
			this.c = c;
		}
	}

	static int bfs() {
		LinkedList<Node> q = new LinkedList<>();

		Node now;

		int nx1, ny1, nx2, ny2, nd1, nd2;

		int answer = -1;

		q.add(new Node(n - 1, 0, 0, n - 1, 0, 1, 0));
		v[n - 1][0][0][n - 1][0][1] = true;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x1 == 0 && now.y1 == n - 1 && now.x2 == 0 && now.y2 == n - 1) {
				answer = now.c;
				break;
			}
			// 앞으로 전진

			nx1 = now.x1 + dx[now.d1];
			ny1 = now.y1 + dy[now.d1];
			nd1 = now.d1;
			if ((now.x1 == 0 && now.y1 == n - 1) || !inRange(nx1, ny1) || map[nx1][ny1] == 'H') {
				nx1 = now.x1;
				ny1 = now.y1;
			}

			nx2 = now.x2 + dx[now.d2];
			ny2 = now.y2 + dy[now.d2];
			nd2 = now.d2;
			if ((now.x2 == 0 && now.y2 == n - 1) || !inRange(nx2, ny2) || map[nx2][ny2] == 'H') {
				nx2 = now.x2;
				ny2 = now.y2;
			}

			if (!v[nx1][ny1][nd1][nx2][ny2][nd2]) {
				v[nx1][ny1][nd1][nx2][ny2][nd2] = true;
				q.add(new Node(nx1, ny1, nd1, nx2, ny2, nd2, now.c + 1));
			}

			// 좌회전
			nx1 = now.x1;
			ny1 = now.y1;
			nd1 = (now.d1 + 3) % 4;
			nx2 = now.x2;
			ny2 = now.y2;
			nd2 = (now.d2 + 3) % 4;

			if (!v[nx1][ny1][nd1][nx2][ny2][nd2]) {
				v[nx1][ny1][nd1][nx2][ny2][nd2] = true;
				q.add(new Node(nx1, ny1, nd1, nx2, ny2, nd2, now.c + 1));
			}

			// 우회전
			nx1 = now.x1;
			ny1 = now.y1;
			nd1 = (now.d1 + 1) % 4;
			nx2 = now.x2;
			ny2 = now.y2;
			nd2 = (now.d2 + 1) % 4;

			if (!v[nx1][ny1][nd1][nx2][ny2][nd2]) {
				v[nx1][ny1][nd1][nx2][ny2][nd2] = true;
				q.add(new Node(nx1, ny1, nd1, nx2, ny2, nd2, now.c + 1));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new char[n][];
		v = new boolean[n][n][4][n][n][4];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int answer = bfs();

		System.out.println(answer);
	}
}
