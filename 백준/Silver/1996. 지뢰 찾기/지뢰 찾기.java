import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] dx = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dy = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];

		char[] row;
		int c = 0;
		int x, y;

		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (row[j] == '.')
					continue;
				c = row[j] - '0';

				for (int k = 0; k < 8; k++) {
					x = i + dx[k];
					y = j + dy[k];

					if (x < 0 || x >= n || y < 0 || y >= n)
						continue;
					map[x][y] += c;
				}

				map[i][j] = -1000;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j] < 0 ? "*" : (map[i][j] >= 10 ? "M" : map[i][j]));
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}