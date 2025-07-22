import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int[] dx = new int[] { 0, 1, 1 };
		final int[] dy = new int[] { 1, 0, 1 };

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] bolded = new boolean[n][m];

		char[] row;

		int x, y;

		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();

			for (int j = 0; j < m; j++) {

				if (row[j] == '#') {
					for (int k = 0; k < 3; k++) {
						x = i + dx[k];
						y = j + dy[k];

						if (x >= n || y >= m)
							continue;
						bolded[x][y] = true;
					}
					sb.append("#");
				} else if (bolded[i][j]) {
					sb.append("#");
				} else {
					sb.append(".");
				}
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}