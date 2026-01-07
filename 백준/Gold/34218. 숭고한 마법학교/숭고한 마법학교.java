import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Node {
		int x, y, c;

		public Node(int x, int y, int c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= m);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		// 지도 입력받기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 입구 위치
		st = new StringTokenizer(br.readLine(), " ");

		int sx = Integer.parseInt(st.nextToken()) - 1;
		int sy = Integer.parseInt(st.nextToken()) - 1;

		// 대회장 위치
		st = new StringTokenizer(br.readLine(), " ");

		int ex = Integer.parseInt(st.nextToken()) - 1;
		int ey = Integer.parseInt(st.nextToken()) - 1;

		LinkedList<Node> q = new LinkedList<>();
		LinkedList<Node> S = new LinkedList<>();

		int nx, ny;
		Node now;

		// 입구에서부터 텔레포트하지않고 갈 수 있는 곳 탐색
		S.add(new Node(sx, sy, 0));
		map[sx][sy] = 2;

		while (!S.isEmpty()) {
			now = S.poll();
			q.add(now);

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] != 1)
					continue;

				map[nx][ny] = 2;
				S.add(new Node(nx, ny, 0));
			}
		}

		int answer = 0;

		// 시작점과 도착점이 이어져있지 않다면
		if (map[ex][ey] != 2) {

			// 도착지점에서부터 텔레포트하지않고 도달할 수 있는곳 찾기
			LinkedList<Node> E = new LinkedList<>();

			E.add(new Node(ex, ey, 0));
			map[ex][ey] = 3;

			while (!E.isEmpty()) {
				now = E.poll();

				for (int i = 0; i < 4; i++) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];

					if (!inRange(nx, ny) || map[nx][ny] != 1)
						continue;

					map[nx][ny] = 3;
					E.add(new Node(nx, ny, 0));
				}
			}

			// 텔레포트 최단거리 구하기
			end: while (!q.isEmpty()) {
				now = q.poll();

				for (int i = 0; i < 4; i++) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];

					if (!inRange(nx, ny) || map[nx][ny] == 2)
						continue;
					else if (map[nx][ny] == 3) {// 도착지점과 연결된 지점이라면 탈출
						answer = now.c + 1;
						break end;
					} else {
						map[nx][ny] = 2;
						q.add(new Node(nx, ny, now.c + 1));
					}
				}
			}
		}

		System.out.println(answer);
	}
}