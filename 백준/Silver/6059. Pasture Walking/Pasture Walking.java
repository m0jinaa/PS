import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		final int INF = 1_000_000_007;

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int[][] dist = new int[n + 1][n + 1];

		int a, b, c;

		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist[i], INF);
		}
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			dist[a][b] = c;
			dist[b][a] = c;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (k == i || dist[i][k] == INF)
					continue;
				for (int j = 1; j <= n; j++) {
					if (k == j || i == j || dist[k][j] == INF)
						continue;

					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			sb.append(dist[a][b]).append("\n");
		}

		System.out.print(sb.toString());

	}
}