import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static int[][] v;
	static LinkedList<Node> q;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int bfs() {
		Node now;
		int nx, ny;
		int max = 0;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[nx][ny] != 'T' || v[nx][ny] != -1)
					continue;
				v[nx][ny] = v[now.x][now.y] + 1;
				max = Math.max(max, v[nx][ny]);
				q.add(new Node(nx, ny));
			}
		}

		return (int) Math.floor(Math.log10(max)) + 2;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		v = new int[n][m];
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(v[i], -1);
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '.') {
					v[i][j] = 0;
					q.add(new Node(i, j));
				}
			}
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && map[i][j] == 'T') {
					v[i][j] = 1;
					q.add(new Node(i, j));
				}
			}
		}
		int digit = bfs();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (digit == 2) {
					if (map[i][j] == '.') {
						sb.append("..");
					} else {
						sb.append(String.format("%2d", v[i][j]).replaceAll(" ", "."));
					}
				} else {
					if (map[i][j] == '.') {
						sb.append("...");
					} else {
						sb.append(String.format("%3d", v[i][j]).replaceAll(" ", "."));
					}
				}
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}