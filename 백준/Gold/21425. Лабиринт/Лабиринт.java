import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, h;
	static int[] dx = new int[] { 0, 0, 1, -1, 0};
	static int[] dy = new int[] { 1, -1, 0, 0, 0 };
	static int[] dz = new int[] { 0, 0, 0, 0, 1};

	static class Loc {
		int z, x, y, c;

		public Loc(int z, int x, int y, int c) {
			super();
			this.z = z;
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	static boolean inRange(int a, int b, int c) {
		if (a < 0 || a >= h || b < 0 || b >= m || c < 0 || c >= n)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		h = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		int[][][] map = new int[h][m][n];

		LinkedList<Loc> q = new LinkedList<Loc>();
		int ex = 0, ey = 0, ez = 0;

		char[] arr;
		boolean[][][] v = new boolean[h][m][n];
		String input;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < m; j++) {
				while((input = br.readLine())==null || input.isEmpty());
				arr = input.toCharArray();
				for (int k = 0; k < n; k++) {
					switch (arr[k]) {
					case '1':
						q.add(new Loc(i, j, k, 0));
						v[i][j][k] = true;
					case '.':
						map[i][j][k] = 0;
						break;
					case 'o':
						map[i][j][k] = 1;
						break;
					case '2':
						map[i][j][k] = 0;
						ez = i;
						ex = j;
						ey = k;
						break;
					}
				}
			}
		}
		
		Loc now;
		int nx, ny, nz;
		int answer = 0;
		
		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == ex && now.y == ey && now.z == ez) {
				answer = 5*now.c;
				break;
			}
			for(int i = 0;i<5;i++) {
				nz = now.z+dz[i];
				nx = now.x+dx[i];
				ny = now.y+dy[i];
				if(!inRange(nz,nx,ny) ||map[nz][nx][ny]==1|| v[nz][nx][ny])
					continue;
				v[nz][nx][ny] = true;
				q.add(new Loc(nz,nx,ny,now.c+1));
			}
		}
		
		System.out.println(answer);
	}
}