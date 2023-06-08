import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= r || y < 0 || y >= c)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		char[][] map = new char[r][];
		boolean[][] v = new boolean[r][c];

		int nx, ny;

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		boolean canGo = false;
		end: for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'W') {
					for (int k = 0; k < 4; k++) {
						nx = i + dx[k];
						ny = j + dy[k];
						if (!inRange(nx, ny) || map[nx][ny] == 'D' || map[nx][ny] == 'W')
							continue;
						if (map[nx][ny] == 'S') {
							canGo = true;
							break end;
						} else {
							map[nx][ny] = 'D';
						}
					}
				}
			}
		}

		if (canGo) {
			sb.append("0\n");
		} else {
			sb.append("1\n");
			for (char[] row : map) {
				for (char m : row) {
					sb.append(m);
				}
				sb.append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}