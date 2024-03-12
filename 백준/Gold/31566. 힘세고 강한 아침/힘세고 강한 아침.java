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
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int[][][] cost = new int[n + 1][n + 1][n + 1];

		int b, t, c;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			b = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= n; i++) {
				if (i != b && i != t) {
					cost[i][b][t] = c;
				}
			}
		}

		for (int x = 1; x <= n; x++) {
			for (int k = 1; k <= n; k++) {
				if (x == k)
					continue;
				for (int i = 1; i <= n; i++) {
					if (k == i)
						continue;
					for (int j = 1; j <= n; j++) {
						if (j == i || j == k)
							continue;
						if (cost[x][i][k] > 0 && cost[x][k][j] > 0) {
							if (cost[x][i][j] == 0)
								cost[x][i][j] = cost[x][i][k] + cost[x][k][j];
							else {
								cost[x][i][j] = Math.min(cost[x][i][j], cost[x][i][k] + cost[x][k][j]);
							}
						}
					}
				}
			}
		}

		int s, k, e;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			sb.append(cost[k][s][e] == 0 ? "No" : cost[k][s][e]).append("\n");
		}

		System.out.println(sb.toString());

	}
}