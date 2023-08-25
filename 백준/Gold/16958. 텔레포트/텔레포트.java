import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[][] cities = new int[n + 1][];

		int[][] time = new int[n + 1][n + 1];

		int s, x, y;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			cities[i] = new int[] { s, x, y };

			for (int j = 1; j < i; j++) {
				time[i][j] = time[j][i] = Math.abs(x - cities[j][1]) + Math.abs(y - cities[j][2]);

				if (s == 1 && s == cities[j][0]) {
					time[i][j] = time[j][i] = Math.min(time[i][j], t);
				}

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

		int m = Integer.parseInt(br.readLine());

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			sb.append(time[x][y]).append("\n");
		}

		System.out.print(sb.toString());
	}
}