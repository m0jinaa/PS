import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, s, t;
	static int[][] map;
	static char[][] plan;

	static int getTree1(int x, int y) {// 회전 x

		int sum = 0;

		for (int i = 0; i < s; i++) {
			for (int j = 0; j < t; j++) {
				if (plan[i][j] != '#')
					continue;
				sum += map[x + i][y + j];
			}
		}

		return sum;
	}

	static int getTree2(int x, int y) {// 90도 회전

		int sum = 0;

		for (int i = 0; i < s; i++) {
			for (int j = 0; j < t; j++) {
				if (plan[i][j] != '#')
					continue;
				sum += map[x + j][y - i];
			}
		}

		return sum;
	}

	static int getTree3(int x, int y) { // 180도 회전

		int sum = 0;

		for (int i = 0; i < s; i++) {
			for (int j = 0; j < t; j++) {
				if (plan[i][j] != '#')
					continue;
				sum += map[x - i][y - j];
			}
		}

		return sum;
	}

	static int getTree4(int x, int y) { // 270도 회전

		int sum = 0;

		for (int i = 0; i < s; i++) {
			for (int j = 0; j < t; j++) {
				if (plan[i][j] != '#')
					continue;
				sum += map[x - j][y + i];
			}
		}

		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int totalTree = 0;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				totalTree += map[i][j];
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		plan = new char[s][];

		for (int i = 0; i < s; i++) {
			plan[i] = br.readLine().toCharArray();
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i + s <= n && j + t <= m) {
					answer = Math.max(answer, totalTree - getTree1(i, j));
				}
				if (i + t <= n && j + 1 >= s) {
					answer = Math.max(answer, totalTree - getTree2(i, j));
				}
				if (i + 1 >= s && j + 1 >= t) {
					answer = Math.max(answer, totalTree - getTree3(i, j));
				}
				if (i + 1 >= t && j + s <= m) {
					answer = Math.max(answer, totalTree - getTree4(i, j));
				}
			}
		}

		System.out.println(answer);
	}
}