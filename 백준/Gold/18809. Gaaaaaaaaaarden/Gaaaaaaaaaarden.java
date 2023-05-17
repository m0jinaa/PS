import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, g, r;
	static final int INF = 3000;
	static int answer;
	static int[][] map;
	static int[][][] v;
	static int cnt;
	static int[][] canDrop;
	static int[] selected;
	
	static LinkedList<Block> q;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Block {
		int x, y, type;

		public Block(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	static boolean inRange(int a, int b) {
		if (a < 0 || a >= n || b < 0 || b >= m) {
			return false;
		}
		return true;
	}

	static void test() {

		q.clear();
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < 2; k++) {
					v[i][j][k] = INF;
				}
			}
		}

		for(int i = 0;i<cnt;i++) {
			if(selected[i]!=0) {
				q.add(new Block(canDrop[i][0],canDrop[i][1],selected[i]-1));
				v[canDrop[i][0]][canDrop[i][1]][selected[i]-1] = 0;
			}
		}
		
		Block now;
		
		int nx, ny;
		int bloom = 0;
		while (!q.isEmpty()) {
			now = q.poll();
			if (v[now.x][now.y][0] == v[now.x][now.y][1]) {
				if(now.type == 0)
					bloom++;
				continue;
			}
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny) || map[nx][ny] == 0 || v[nx][ny][now.type] != INF) {
					continue;
				}

				v[nx][ny][now.type] = v[now.x][now.y][now.type] + 1;

				q.add(new Block(nx, ny, now.type));
			}
		}
		answer = Math.max(answer, bloom);
	}

	static void red(int ind, int c) {
		if (c == r) {
			test();
		}
		else if(ind==cnt) {
			return;
		}
		else {
			if(selected[ind]!=0) {
				red(ind+1,c);
			}
			else {
				//선택
				selected[ind] = 2;
				red(ind+1,c+1);
				//선택x
				selected[ind] = 0;
				red(ind+1,c);
				
			}
		}
	}
	
	static void green(int ind, int c) {
		if (c == g) {
			red(0,0);
		}
		else if(ind==cnt) {
			return;
		}
		else {
			//선택
			selected[ind] = 1;
			green(ind+1,c+1);
			//선택x
			selected[ind] = 0;
			green(ind+1,c);
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new int[n][m][2];

		q = new LinkedList<>();

		canDrop = new int[10][2];
		cnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					map[i][j] = 1;
					canDrop[cnt][0] = i;
					canDrop[cnt++][1] = j;
				}
			}
		}
		
		selected = new int[cnt];
		
		answer = 0;

		green(0,0);

		System.out.println(answer);
	}
}