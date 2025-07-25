import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = new int[] { 1, -1, 0, 0 };
	static int[] dy = new int[] { 0, 0, 1, -1 };
	static int[] cnt;
	static LinkedList<Node> q;
	static LinkedList<Node>[] list;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static void check(int ind) {

		Node now;
		int nx, ny;

		while (!list[ind].isEmpty()) {
			now = list[ind].poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || v[nx][ny])
					continue;
				v[nx][ny] = true;
				list[map[nx][ny]].add(new Node(nx, ny));
				getSameColor(nx, ny);
			}
		}
	}

	static void getSameColor(int x, int y) {
		q.clear();
		q.add(new Node(x, y));

		int nx, ny;
		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || v[nx][ny] || map[nx][ny] != map[x][y])
					continue;
				v[nx][ny] = true;
				list[map[x][y]].add(new Node(nx, ny));
				q.add(new Node(nx, ny));
			}
		}
	}

	static int getMinCnt() {
		int change = 0;

		list[map[0][0]].add(new Node(0, 0));
		v[0][0] = true;
		int ind;
		int c;

		while (true) {
			ind = 0;
			c = 0;
			for (int i = 1; i < 7; i++) {
				if (list[i].size() <= c)
					continue;
				ind = i;
				c = list[i].size();
			}

			if (c == 0)
				break;

			change++;
			check(ind);
			cnt[ind]++;
		}

		cnt[map[0][0]]--;
		return change - 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		char[] row;
		cnt = new int[7];
		list = new LinkedList[7];
		q = new LinkedList<>();

		for (int i = 1; i < 7; i++) {
			list[i] = new LinkedList<>();
		}

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());

			map = new int[n][n];
			v = new boolean[n][n];

			Arrays.fill(cnt, 0);
			for (int i = 1; i < 7; i++) {
				list[i].clear();
			}

			for (int i = 0; i < n; i++) {
				row = br.readLine().toCharArray();

				for (int j = 0; j < n; j++) {
					map[i][j] = row[j] - '0';
				}
			}

			sb.append(getMinCnt()).append("\n");
			for (int i = 1; i < 7; i++) {
				sb.append(cnt[i]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}