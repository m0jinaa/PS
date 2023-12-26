import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] sum;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		sum = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= n; j++) {
				sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		int q = Integer.parseInt(br.readLine());

		int r1, r2, c1, c2;

		int total, inside;
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			r1 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());

			total = sum[r2][c2] - sum[r1 - 1][c2] - sum[r2][c1 - 1] + sum[r1 - 1][c1 - 1];
			inside = sum[r2 - 1][c2 - 1] - sum[r1][c2 - 1] - sum[r2 - 1][c1] + sum[r1][c1];

			sb.append(2 * inside - total).append("\n");

		}

		System.out.println(sb.toString());
	}
}