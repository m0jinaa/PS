import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = new int[] { 0, 0, 1, -1 };
	static final int[] dy = new int[] { 1, -1, 0, 0 };
	static int n, m;
	static char[][] map;
	static boolean[][][] v;

	static class Node {
		int x, y, c, d;

		public Node(int x, int y, int c, int d) {
			super();
			this.x = x; // 행
			this.y = y; // 열
			this.c = c; // 몇 번째 체크포인트까지 도달
			this.d = d; // 이동 거리
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int answer, nx, ny, nc, sx = -1, sy = -1, ex = -1, ey = -1, k;
		Node now;

		LinkedList<Node> q = new LinkedList<>();

		while (tc-- > 0) {
			q.clear();
			answer = 0;

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			map = new char[n][];
			v = new boolean[n][m][k + 1];
            
            //맵 정보 받고 시작점, 끝점 위치 찾기
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 'S') {
						sx = i;
						sy = j;
						map[i][j] = '.';
					} else if (map[i][j] == 'E') {
						ex = i;
						ey = j;
						map[i][j] = '.';
					}
				}
			}

			q.add(new Node(sx, sy, 0, 0));
			v[sx][sy][0] = true;

			while (!q.isEmpty()) {
				now = q.poll();
                
                //모든 체크포인트를 돌고 끝점 도달 시 탈출
				if (now.x == ex && now.y == ey && now.c == k) {
					answer = now.d;
					break;
				}
                
				for (int i = 0; i < 4; i++) {
					nx = now.x + dx[i];
					ny = now.y + dy[i];
                    
                    //맵을 벗어나거나 벽인 경우
					if (!inRange(nx, ny) || map[nx][ny] == '#')
						continue;
                    
                    //체크포인트 도달 여부 확인
					if (map[nx][ny] != '.' && map[nx][ny] - '0' == now.c + 1) {
						nc = now.c + 1;
					} else {
						nc = now.c;
					}
                    
                    //이미 같은 조건에서 방문했으면 패스
					if (v[nx][ny][nc])
						continue;

					v[nx][ny][nc] = true;
					q.add(new Node(nx, ny, nc, now.d + 1));
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}