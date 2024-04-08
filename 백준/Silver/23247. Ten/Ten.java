import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] sum = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= m; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;

		int s;

		for (int sx = 1; sx <= n; sx++) {
			for (int sy = 1; sy <= m; sy++) {
				for (int ex = sx; ex <= n; ex++) {
					for (int ey = sy; ey <= m; ey++) {
						s = sum[ex][ey] - sum[sx - 1][ey] - sum[ex][sy - 1] + sum[sx - 1][sy - 1];

						if (s == 10) {
							cnt++;
						} else if (s > 10) {
							break;
						}
					}
				}
			}
		}

		System.out.println(cnt);
	}
}