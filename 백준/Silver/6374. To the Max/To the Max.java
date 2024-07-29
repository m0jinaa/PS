import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int i = 0;

		int[][] sum = new int[n + 1][n + 1];
		int x, y, v;

		while (i < n * n) {
			st = new StringTokenizer(br.readLine(), " ");

			while (st.hasMoreTokens()) {
				v = Integer.parseInt(st.nextToken());
				x = i / n + 1;
				y = i % n + 1;

				sum[x][y] = sum[x][y - 1] + sum[x - 1][y] - sum[x - 1][y - 1] + v;
				i++;
			}
		}

		int answer = -1_000_000_007;

		int total;

		for (int sx = 1; sx <= n; sx++) {
			for (int sy = 1; sy <= n; sy++) {
				for (int ex = sx; ex <= n; ex++) {
					for (int ey = sy; ey <= n; ey++) {
						total = sum[ex][ey] - sum[ex][sy - 1] - sum[sx - 1][ey] + sum[sx - 1][sy - 1];
						answer = Math.max(answer, total);
					}
				}
			}
		}

		System.out.println(answer);
	}
}