import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_007;
	static int[][] map;
	static boolean[][] v;
	static int r, c, car, lot;
	static int[] dx = new int[] { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static ArrayList<Integer>[] canPark;
	static ArrayList<Dist>[] candidates;
	static int[] parked, park, level;
	static boolean[] used;
	static LinkedList<Node> q;

	static class Node {
		int x, y, d;

		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static class Dist {
		int x, d;

		public Dist(int x, int d) {
			super();
			this.x = x;
			this.d = d;
		}
	}

	static void init() {
		for (int i = 0; i < r; i++) {
			Arrays.fill(v[i], false);
		}
		q.clear();
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= r || y < 0 || y >= c) {
			return false;
		}
		return true;
	}

	static void bfs(int x, int y, int ind) {
		init();

		q.add(new Node(x, y, 0));

		v[x][y] = true;
		Node now;
		int nx, ny, nd;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || v[nx][ny] || map[nx][ny] == -1)
					continue;
				v[nx][ny] = true;
				nd = now.d + 1;
				if (map[nx][ny] > 100) {
					candidates[ind].add(new Dist(map[nx][ny] - 100, nd));
				}

				q.add(new Node(nx, ny, nd));
			}
		}
	}

	static void setLevel() {
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 1; i < car; i++) {
			if (!used[i]) {
				list.add(i);
				level[i] = 0;
			} else {
				level[i] = INF;
			}
		}
		int x;
		while (!list.isEmpty()) {
			x = list.poll();

			for (int y : canPark[x]) {
				if (parked[y] != 0 && level[parked[y]] == INF) {
					level[parked[y]] = level[x] + 1;
					list.add(parked[y]);
				}
			}
		}
	}

	static boolean match(int x) {
		for (int y : canPark[x]) {
			if (parked[y] == 0 || (level[parked[y]] == level[x] + 1 && match(parked[y]))) {
				used[x] = true;
				parked[y] = x;
				park[x] = y;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		v = new boolean[r][c];

		char[] row;
		car = 1;
		lot = 101;

		for (int i = 0; i < r; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (row[j] == 'C') {
					map[i][j] = car++;
				} else if (row[j] == 'X') {
					map[i][j] = -1;
				} else if (row[j] == 'P') {
					map[i][j] = lot++;
				}
			}
		}

		lot -= 100;
		candidates = new ArrayList[car];
		canPark = new ArrayList[car];

		for (int i = 1; i < car; i++) {
			candidates[i] = new ArrayList<>();
			canPark[i] = new ArrayList<>();

		}

		used = new boolean[car];
		park = new int[car];
		level = new int[car];

		parked = new int[lot];

		q = new LinkedList<Node>();

		int ind = 1;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] <= 0 || map[i][j] > 100)
					continue;

				bfs(i, j, ind++);
			}
		}

		int s = 0;
		int e = INF;
		int m;
		int answer = -1;
		int total, d;
		while (s <= e) {
			m = (s + e) / 2;

			for (int i = 1; i < car; i++) {
				canPark[i].clear();
				for (Dist dist : candidates[i]) {
					if (dist.d <= m)
						canPark[i].add(dist.x);
				}
			}

			Arrays.fill(park, 0);
			Arrays.fill(parked, 0);
			Arrays.fill(used, false);
			total = 0;

			while (true) {
				setLevel();

				d = 0;
				for (int i = 1; i < car; i++) {
					if (used[i])
						continue;
					if (match(i))
						d++;
				}

				if (d == 0)
					break;
				total += d;
			}

			if (total == car - 1) {
				answer = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		System.out.println(answer);
	}
}