import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] box;
	static boolean[][] v;
	static int n = 3;
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
		return !(x < 0 || x >= n || y < 0 || y >= n);
	}

	static int bfs(int x, int y) {
		int cnt = 1;

		v[x][y] = true;

		q.clear();

		q.add(new Node(x, y));

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || box[nx][ny] != 'O' || v[nx][ny])
					continue;
				v[nx][ny] = true;
				cnt++;
				q.add(new Node(nx, ny));

			}
		}

		return cnt;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		q = new LinkedList<>();
		int m, ind;
		int[] test;
		box = new char[n][];
		v = new boolean[n][n];

		while (tc-- > 0) {
			for (int i = 0; i < n; i++) {
				box[i] = br.readLine().toCharArray();
				Arrays.fill(v[i], false);
			}

			list.clear();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if ((i == 1 && j == 1) || box[i][j] != 'O' || v[i][j])
						continue;
					list.add(bfs(i, j));
				}
			}

			Collections.sort(list);

			st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());

			test = new int[m];

			for (int i = 0; i < m; i++) {
				test[i] = Integer.parseInt(st.nextToken());
			}

			if (m != list.size()) {
				sb.append("0\n");
			} else {
				ind = 0;
				for (int l : list) {
					if (test[ind] != l) {
						break;
					}
					ind++;
				}

				if (ind == m) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			}
		}

		System.out.print(sb.toString());
	}
}