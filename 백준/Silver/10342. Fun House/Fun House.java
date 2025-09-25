import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] dx = new int[] { 0, -1, 0, 1 };
		int[] dy = new int[] { 1, 0, -1, 0 };

		int[] slash = new int[] { 1, 0, 3, 2 };
		int[] backslash = new int[] { 3, 2, 1, 0 };

		int n, m;
		char[][] map;
		int x = -1, y = -1, d = -1;
		int house = 0;
		while (true) {

			// 가로 세로 입력받기
			st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			// 탈출조건 확인
			if (n == 0 && m == 0)
				break;

			// 몇번째 집인지 업데이트
			house++;

			// 지도 입력받기
			map = new char[n][];

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					// 시작지점 찾기
					if (map[i][j] == '*') {
						x = i;
						y = j;
						if (i == 0)
							d = 3;
						else if (j == 0)
							d = 0;
						else if (i == n - 1)
							d = 1;
						else
							d = 2;
					}
				}
			}

			// 벽에 닿을때까지 움직이기
			while (map[x][y] != 'x') {
				x += dx[d];
				y += dy[d];

				if (map[x][y] == '/') {
					d = slash[d];
				} else if (map[x][y] == '\\') {
					d = backslash[d];
				}
			}

			map[x][y] = '&';

			sb.append("HOUSE ").append(house).append("\n");

			for (int i = 0; i < n; i++) {
				sb.append(String.valueOf(map[i])).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}