import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] cost = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(cost[i], 1, n + 1, INF);
			cost[i][i] = 0;
		}

		int a = 0, b = 0;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			cost[a][b] = 1;
			cost[b][a] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (k == i)
					continue;
				for (int j = 1; j <= n; j++) {
					if (i == j || j == k)
						continue;
					cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
				}
			}
		}

		int time = INF;
		int t;
		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				t = 0;
				for (int k = 1; k <= n; k++) {
					t += Math.min(cost[k][i], cost[k][j]);
				}

				if (t < time) {
					time = t;
					a = i;
					b = j;
				}
			}
		}

		System.out.println(a + " " + b + " " + time * 2);
	}
}