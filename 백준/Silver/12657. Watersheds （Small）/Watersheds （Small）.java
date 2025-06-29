import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final char[] alphabet = new char[] { ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	static int l = 1;
	static int n, m;

	// 살펴보는 순서는 북->서->동->남
	static final int[] dx = new int[] { -1, 0, 0, 1 };
	static final int[] dy = new int[] { 0, -1, 1, 0 };
	static int[][] map;
	static int[][] label;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	// return label for basin : 1~26
	static int findSink(int x, int y) {
		if (label[x][y] != 0)
			return label[x][y];

		int d = -1;
		int min = map[x][y];

		int nx, ny;

		// 인접한 네 방향 살펴보고 가장 낮은 곳 찾기
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (!inRange(nx, ny) || map[nx][ny] >= min)
				continue;
			d = i;
			min = map[nx][ny];
		}

		// 여기가 가장 낮은 곳이면
		if (d == -1) {
			return label[x][y] = l++;
		} else {
			return label[x][y] = findSink(x + dx[d], y + dy[d]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			label = new int[n][m];
			l = 1;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (label[i][j] != 0)
						continue;
					findSink(i, j);
				}
			}

			sb.append("Case #").append(t).append(":\n");

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					sb.append(alphabet[label[i][j]]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}