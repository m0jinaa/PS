import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		final int INF = 1_000_000_007;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int[][][] cost = new int[n + 1][n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				cost[i][j][0] = Integer.parseInt(st.nextToken());

				if (i == j)
					continue;

				if (cost[i][j][0] == 0)
					cost[i][j][0] = INF;
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					cost[i][j][k] = Math.min(cost[i][j][k - 1], cost[i][k][k - 1] + cost[k][j][k - 1]);
				}
			}
		}

		int c, s, e;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			sb.append(cost[s][e][c - 1] != INF ? cost[s][e][c - 1] : -1).append("\n");
		}

		System.out.print(sb.toString());
	}
}