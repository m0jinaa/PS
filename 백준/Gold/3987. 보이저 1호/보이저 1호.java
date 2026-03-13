import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_007;
	static int n, m;
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static char[][] map;
	static boolean[][][] v;

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= m);
	}

	static int getDist(int x, int y, int d) {
		int cnt = 0;

		v = new boolean[n][m][4];

		// 맵을 벗어나거나 블랙홀이 아닌 경우
		while (inRange(x, y) && map[x][y] != 'C') {

			if (v[x][y][d]) {
				cnt = INF;
				break;
			}
			v[x][y][d] = true;

			cnt++;

			// 행성을 만났을 때 방향 전환
			if (map[x][y] == '/') {
				if (d % 2 == 0) {
					d++;
				} else {
					d--;
				}
			} else if (map[x][y] == '\\') {
				if (d % 2 == 0) {
					d = (d + 3) % 4;
				} else {
					d = (d + 1) % 4;
				}
			}

			x += dx[d];
			y += dy[d];
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 맵 크기
		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 맵
		map = new char[n][];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 시작지점
		st = new StringTokenizer(br.readLine(), " ");

		int sx = Integer.parseInt(st.nextToken()) - 1;
		int sy = Integer.parseInt(st.nextToken()) - 1;

		int answer = -1;
		int answerD = -1;

		int ret;

		for (int i = 0; i < 4; i++) {
			ret = getDist(sx, sy, i);

			if (ret > answer) {
				answer = ret;
				answerD = i;
			}
		}

		if (answerD != -1) {
			char[] D = new char[] { 'U', 'R', 'D', 'L' };

			sb.append(D[answerD]).append("\n");
		}

		sb.append(answer == INF ? "Voyager" : answer).append("\n");

		System.out.println(sb.toString());
	}
}