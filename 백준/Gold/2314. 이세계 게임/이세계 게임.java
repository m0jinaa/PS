import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static class Node {
		int x, c;

		public Node(int x, int c) {
			super();
			this.x = x;
			this.c = c;
		}
	}

	static LinkedList<Node> q = new LinkedList<>();
	static int n = 4, m = 16, target;
	static boolean[] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static int bfs(int start) {
		q.add(new Node(start, 0));
		v[start] = true;
		Node now;

		int x, y, nx, ny, p;

		int answer = -1;
		int next;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == target) {
				answer = now.c;
				break;
			}

			for (int i = 0; i < m; i++) {
				if ((now.x & (1 << i)) == 0) // L일 때
					continue;

				x = i / n;
				y = i % n;

				for (int j = 0; j < 4; j++) {
					nx = x + dx[j];
					ny = y + dy[j];

					if (!inRange(nx, ny)) // 격자 벗어남
						continue;

					p = 1 << (nx * n + ny);
					if ((now.x & p) != 0) // P일 때
						continue;

					next = (now.x ^ (1 << i)) | p;

					if (v[next]) // 이미 만들어 본 구성
						continue;

					v[next] = true;
					q.add(new Node(next, now.c + 1));
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int now = 0;
		char[] row;

		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (row[j] == 'P') {
					now += (1 << (i * n + j));
				}
			}
		}

		target = 0;

		br.readLine();

		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (row[j] == 'P') {
					target += (1 << (i * n + j));
				}
			}
		}

		v = new boolean[1 << (n * n)];

		System.out.println(bfs(now));
	}
}