import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 256;
	static int n, b;
	static int[][] dp, matrix;

	static void getDiff(int x, int y) {

		int max = -INF;
		int min = INF;

		for (int i = x; i < x + b; i++) {
			for (int j = y; j < y + b; j++) {
				max = Math.max(max, matrix[i][j]);
				min = Math.min(min, matrix[i][j]);
			}
		}

		dp[x][y] = max - min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		dp = new int[n + 1][n + 1];
		matrix = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i + b - 1 <= n; i++) {
			for (int j = 1; j + b - 1 <= n; j++) {
				getDiff(i, j);
			}
		}

		int x, y;

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			sb.append(dp[x][y]).append("\n");
		}

		System.out.print(sb.toString());
	}
}