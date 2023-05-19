import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Loc {
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static boolean bfs() {

		boolean possible = false;

		int nx, ny;

		LinkedList<Loc> q = new LinkedList<>();
        
		int k;
        
		q.add(new Loc(0, 0));
        
		Loc now;
        
		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == n - 1 && now.y == n - 1) {
				possible = true;
				break;
			}

			k = map[now.x][now.y];

			// 오른쪽
			if (now.y + k < n && !v[now.x][now.y + k]) {
				v[now.x][now.y + k] = true;
				q.add(new Loc(now.x, now.y + k));
			}

			// 아래쪽
			if (now.x + k < n && !v[now.x + k][now.y]) {
				v[now.x + k][now.y] = true;
				q.add(new Loc(now.x + k, now.y));
			}
		}

		return possible;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		v = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs() ? "HaruHaru" : "Hing");
	}
}