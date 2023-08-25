import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] time = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= n; j++) {
				time[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (k == i)
					continue;

				for (int j = 1; j <= n; j++) {
					if (k == j || i == j)
						continue;

					time[i][j] = Math.min(time[i][j], time[i][k] + time[k][j]);
				}
			}
		}

		int a, b, c;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			sb.append(c >= time[a][b] ? "Enjoy other party\n" : "Stay here\n");
		}

		System.out.print(sb.toString());
	}
}