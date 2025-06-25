import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] v;
	static LinkedList<Node> q;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node implements Comparable<Node> {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node node) {
			return map[node.x][node.y] - map[this.x][this.y];
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static boolean bfs(int x, int y) {
		q.clear();

		q.add(new Node(x, y));
		v[x][y] = true;

		boolean possible = true;

		Node now;
		int nx, ny, d;

		end: while (!q.isEmpty()) {
			now = q.poll();

			if (map[now.x][now.y] <= 1)
				continue;

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == -1)
					continue;
				d = map[now.x][now.y] - map[nx][ny];

				if (d == 1 && !v[nx][ny]) {
					v[nx][ny] = true;
					q.add(new Node(nx, ny));
				} else if (d > 1) {
					possible = false;
					break end;
				}
			}
		}

		return possible;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m];
		q = new LinkedList<>();

		LinkedList<Node> brightest = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] > 0)
					brightest.add(new Node(i, j));
			}
		}

		Collections.sort(brightest);

		int answer = 0;

		for (Node node : brightest) {
			if (v[node.x][node.y])
				continue;
			else if (bfs(node.x, node.y)) {
				answer++;
			} else {
				answer = -1;
				break;
			}
		}

		System.out.println(answer);
	}
}