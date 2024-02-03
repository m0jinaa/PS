import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] sum = new int[n + 1][m + 1];

		int x;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				x = Integer.parseInt(st.nextToken());
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + x;
			}
		}

		int answer = -1_000_000_007;

		int s;
		for (int x1 = 1; x1 <= n; x1++) {
			for (int y1 = 1; y1 <= m; y1++) {
				for (int x2 = x1; x2 <= n; x2++) {
					for (int y2 = y1; y2 <= m; y2++) {
						s = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
						answer = Math.max(answer, s);
					}
				}
			}
		}

		System.out.println(answer);
	}
}