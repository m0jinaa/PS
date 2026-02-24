import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static boolean[][] v;
	static int[] dx = new int[] { 1, -1, 0, 0 };
	static int[] dy = new int[] { 0, 0, 1, -1 };

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
		return !(x < 0 || x >= n || y < 0 || y >= m);
	}

	static int getSize(int x, int y) {
		q.add(new Node(x, y));
		v[x][y] = true;

		Node now;
		int nx, ny;
		int cnt = 1;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '0' || v[nx][ny])
					continue;
				cnt++;
				q.add(new Node(nx, ny));
				v[nx][ny] = true;
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new boolean[n][m];
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		LinkedList<Integer> lake = new LinkedList<>();
		int size;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '0' || v[i][j])
					continue;
				size = getSize(i, j);

				lake.add(size);
			}
		}

		Collections.sort(lake);

		sb.append(lake.size()).append("\n");

		while (!lake.isEmpty()) {
			sb.append(lake.pop()).append(" ");
		}

		System.out.println(sb.toString());
	}
}