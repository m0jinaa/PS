import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String input;

		int x, q, s, e;

		int[][] dist = new int[21][21];

		int t = 1;

		final int INF = 1_000_000_000;

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			if (t != 1)
				sb.append("\n");

			sb.append("Test Set #").append(t).append("\n");

			for (int i = 1; i <= 20; i++) {
				Arrays.fill(dist[i], INF);
				dist[i][i] = 0;
			}
			st = new StringTokenizer(input, " ");

			int c = Integer.parseInt(st.nextToken());
			while (c-- > 0) {
				x = Integer.parseInt(st.nextToken());
				dist[1][x] = 1;
				dist[x][1] = 1;
			}

			for (int i = 2; i < 20; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				c = Integer.parseInt(st.nextToken());
				while (c-- > 0) {
					x = Integer.parseInt(st.nextToken());
					dist[i][x] = 1;
					dist[x][i] = 1;
				}
			}

			for (int k = 1; k <= 20; k++) {
				for (int i = 1; i <= 20; i++) {
					if (i == k || dist[i][k] == INF)
						continue;
					for (int j = 1; j <= 20; j++) {
						if (j == i || j == k || dist[k][j] == INF)
							continue;
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}

			q = Integer.parseInt(br.readLine());

			while (q-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");

				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());

				sb.append(String.format("%2d to %2d: %d\n", s, e, dist[s][e]));
			}
			t++;
		}

		System.out.print(sb.toString());
	}
}