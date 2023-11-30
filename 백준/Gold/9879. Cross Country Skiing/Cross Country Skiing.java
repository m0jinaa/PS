import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static ArrayList<Point> wayPoints;
	static boolean[][] v;
	static int[][] map;
	static LinkedList<Point> q;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static boolean check(int h) {
		q.clear();
		for (int i = 0; i < n; i++) {
			Arrays.fill(v[i], false);
		}
		Point start = wayPoints.get(0);

		q.add(start);
		v[start.x][start.y] = true;

		Point p;
		int nx, ny;

		while (!q.isEmpty()) {
			p = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];

				if (!inRange(nx, ny) || Math.abs(map[p.x][p.y] - map[nx][ny]) > h || v[nx][ny])
					continue;
				q.add(new Point(nx, ny));
				v[nx][ny] = true;
			}
		}
		boolean answer = true;

		for (Point wp : wayPoints) {
			if (v[wp.x][wp.y])
				continue;
			answer = false;
			break;
		}

		return answer;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m];
		int e = 0;
		int s = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				e = Math.max(map[i][j], e);
			}
		}

		int x;

		wayPoints = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					wayPoints.add(new Point(i, j));
				}
			}
		}

		q = new LinkedList<>();

		int mid;
		int answer = 0;

		while (s <= e) {
			mid = (s + e) / 2;

			if (check(mid)) {
				answer = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}

		System.out.println(answer);
	}
}