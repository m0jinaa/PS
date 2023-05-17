import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n = 5;
	static final int INF = 200;
	static int answer;
	static int[][][] original;
	static int[][][] map;
	static int[][][] v;
	static int[] layer;
	static LinkedList<Block> q;

	static int[] dx = { 0, 0, 0, 0, 1, -1 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 1, -1, 0, 0, 0, 0 };

	static class Block {
		int x, y, z;

		public Block(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static boolean inRange(int a, int b, int c) {
		if (a < 0 || a >= n || b < 0 || b >= n || c < 0 || c >= n) {
			return false;
		}
		return true;
	}

	static void test() {
		if(map[layer[0]][0][0]==0 || map[layer[4]][n-1][n-1]==0)
			return;
		q.clear();
		q.add(new Block(0, 0, 0));
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					v[i][j][k] = INF;
				}
			}
		}
		
		Block now;
		
		v[0][0][0] = 0;
		
		int nx, ny, nz;
		
		while (!q.isEmpty()) {
			now = q.poll();
			if(now.x == n-1 && now.y == n-1 && now.z == n-1) {
				answer = Math.min(answer, v[now.x][now.y][now.z]);
				break;
			}

			for (int i = 0; i < 6; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				nz = now.z + dz[i];
				if(!inRange(nx,ny,nz) || map[layer[nx]][ny][nz]==0 || v[nx][ny][nz]!=INF) {
					continue;
				}
				v[nx][ny][nz] = v[now.x][now.y][now.z]+1;
				q.add(new Block(nx,ny,nz));
			}
		}
	}

	static void permutation(int ind) {
		if (ind == 5) {
			combi(0,0);
			return;
		}
		// 원본
		for (int i = 0; i < n; i++) {
			System.arraycopy(original[layer[ind]][i], 0, map[layer[ind]][i], 0, n);
		}
		permutation(ind+1);
		// 90도
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[layer[ind]][i][j] = original[layer[ind]][j][n - 1 - i];
			}
		}
		permutation(ind+1);

		// 180도
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[layer[ind]][i][j] = original[layer[ind]][n - 1 - i][n - 1 - j];
			}
		}
		permutation(ind+1);

		// 270도
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[layer[ind]][i][j] = original[layer[ind]][n - 1 - j][i];
			}
		}
		permutation(ind+1);
	}
	
	static void combi(int ind , int used) {
		if(ind==n) {
			test();
		}
		for(int i = 0;i<n;i++) {
			if((used & (1<<i))!=0)
				continue;
			layer[ind] = i;
			combi(ind+1,used | (1<<i));
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


		original = new int[n][n][n];
		map = new int[n][n][n];
		v = new int[n][n][n];
		layer = new int[n];
		
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < n; k++) {
					original[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		answer = INF;

		permutation(0);

		System.out.println(answer == INF ? -1 : answer);
	}
}