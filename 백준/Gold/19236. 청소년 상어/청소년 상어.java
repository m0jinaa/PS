import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = new int[] { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int n = 4;

	static class Fish {
		int x, y, d;

		public Fish(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		public void setXY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void turn() {
			this.d = (this.d + 1) % 8;
		}
	}

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= n);
	}

	static int getMax(int shark, int[][] map, Fish[] fish, boolean[] dead) {

		// 물고기 이동
		// 1부터 순서대로, 이동불가하면 방향 반시계방향으로 전환
		int nx, ny, nd, tx, ty, t;
		int[][] newMap = new int[n][n];
		Fish[] newFish = new Fish[n * n + 1];
		boolean[] newDead = new boolean[n * n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		for (int i = 1; i <= n * n; i++) {
			newFish[i] = new Fish(fish[i].x, fish[i].y, fish[i].d);
			newDead[i] = dead[i];
		}

		for (int i = 1; i <= n * n; i++) {
			if (newDead[i] || i == shark)
				continue;

			nx = newFish[i].x + dx[newFish[i].d];
			ny = newFish[i].y + dy[newFish[i].d];

			while (!inRange(nx, ny) || newMap[nx][ny] == shark) {
				newFish[i].turn();
				nx = newFish[i].x + dx[newFish[i].d];
				ny = newFish[i].y + dy[newFish[i].d];
			}

			tx = newFish[i].x;
			ty = newFish[i].y;
			t = newMap[nx][ny];

			newFish[i].setXY(nx, ny);

			if (newMap[nx][ny] != 0) {
				newFish[newMap[nx][ny]].setXY(tx, ty);
			}

			newMap[nx][ny] = newMap[tx][ty];
			newMap[tx][ty] = t;
		}

		// 상어 움직이기
		int max = 0;

		nx = newFish[shark].x + dx[newFish[shark].d];
		ny = newFish[shark].y + dy[newFish[shark].d];

		while (inRange(nx, ny)) {
			// 물고기 있음
			if (newMap[nx][ny] != 0) {
				newDead[newMap[nx][ny]] = true;
				newMap[newFish[shark].x][newFish[shark].y] = 0;

				max = Math.max(getMax(newMap[nx][ny], newMap, newFish, newDead) + newMap[nx][ny], max);

				newMap[newFish[shark].x][newFish[shark].y] = shark;
				newDead[newMap[nx][ny]] = false;
			}

			nx += dx[newFish[shark].d];
			ny += dy[newFish[shark].d];
		}

		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] map = new int[n][n];
		Fish[] fish = new Fish[n * n + 1];
		boolean[] dead = new boolean[n * n + 1];
		int a, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				map[i][j] = a;
				fish[a] = new Fish(i, j, b - 1);
			}
		}

		dead[map[0][0]] = true;
		int answer = map[0][0] + getMax(map[0][0], map, fish, dead);

		System.out.println(answer);
	}
}