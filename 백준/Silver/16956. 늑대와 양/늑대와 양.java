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

		LinkedList<Point> q = new LinkedList<>();

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'W') {
					q.add(new Point(i, j));
					v[i][j] = true;
				}
			}
		}
		boolean canGo = false;
		int nx, ny;
		Point now;
		end: while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || v[nx][ny] || map[nx][ny] == 'D')
					continue;
				if (map[nx][ny] == 'S') {
					if (map[now.x][now.y] == 'W') {
						canGo = true;
						break end;
					}
					map[now.x][now.y] = 'D';
				} else {
					v[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
		
		if(canGo) {
			sb.append(0).append("\n");
		}
		else {
			sb.append(1).append("\n");
			
			for(int i = 0;i<r;i++) {
				for(int j = 0;j<c;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.print(sb.toString());
	}
}