import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] row, column;

	static int[][] snow;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		snow = new int[n][m];
		row = new int[n];
		column = new int[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				snow[i][j] = Integer.parseInt(st.nextToken());
				row[i] += snow[i][j];
				column[j] += snow[i][j];
			}
		}

		int r, c;
		int min;
		final int INF = 1_000_000_007;

		int answer = 0;

		while (true) {
			r = -1;
			c = -1;
			min = INF;

			for (int i = 0; i < n; i++) {
				if (row[i] == 0)
					continue;
				else if (min > row[i]) {
					min = row[i];
					r = i;
				}
			}

			for (int j = 0; j < m; j++) {
				if (column[j] == 0)
					continue;
				else if (min > column[j]) {
					min = column[j];
					r = -1;
					c = j;
				}
			}

			if (min == INF)
				break;

			answer = Math.max(answer, min);

			if (r == -1) {
				column[c] = 0;
				for (int i = 0; i < n; i++) {
					row[i] -= snow[i][c];
					snow[i][c] = 0;
				}
			} else {
				row[r] = 0;
				for (int i = 0; i < m; i++) {
					column[i] -= snow[r][i];
					snow[r][i] = 0;
				}
			}
		}

		System.out.println(answer);
	}
}