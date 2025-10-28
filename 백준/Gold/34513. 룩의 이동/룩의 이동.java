import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static class Rook implements Comparable<Rook> {
		int x, y, d, c;

		public Rook(int x, int y, int d, int c) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}

		@Override
		public int compareTo(Rook r) {
			return this.c - r.c;
		}
	}

	static int n;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] board;
	static boolean[][][] v;

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= n);
	}

	static int getMinMove(int x, int y) {
		PriorityQueue<Rook> q = new PriorityQueue<>();

		q.add(new Rook(x, y, -1, 0));

		v[x][y][0] = true;
		v[x][y][1] = true;
		v[x][y][2] = true;
		v[x][y][3] = true;

		int answer = -1;

		Rook now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			if (board[now.x][now.y] == 'K') {
				answer = now.c;
				break;
			}

			for (int i = 0; i < 4; i++) {

				nx = now.x + dx[i];
				ny = now.y + dy[i];

				while (inRange(nx, ny) && board[nx][ny] != 'B') {
					if (!v[nx][ny][i]) {
						v[nx][ny][i] = true;
						q.add(new Rook(nx, ny, (board[nx][ny] != '.') ? -1 : i, now.c + (i == now.d ? 0 : 1)));
					} else {
						break;
					}

					// 백의 기물 또는 백의 킹을 잡았다면 여기서 멈춰야함
					if (board[nx][ny] == 'W' || board[nx][ny] == 'K') {
						break;
					}

					nx += dx[i];
					ny += dy[i];
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new char[n][];
		v = new boolean[n][n][4];

		int sx = -1;
		int sy = -1;

		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();

			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'R') {
					sx = i;
					sy = j;
					board[i][j] = '.';
				}
			}
		}

		int answer = getMinMove(sx, sy);

		System.out.println(answer);
	}
}