import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] sum = new int[n + 1][n + 1];

		int x;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				x = Integer.parseInt(st.nextToken());

				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + x;
			}
		}

		int sx, sy, ex, ey;
		int v;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sx = Math.max(1, i - r);
				sy = Math.max(1, j - r);
				ex = Math.min(n, i + r);
				ey = Math.min(n, j + r);

				v = sum[ex][ey] - sum[sx - 1][ey] - sum[ex][sy - 1] + sum[sx - 1][sy - 1];
				sb.append(v).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}