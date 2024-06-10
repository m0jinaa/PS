import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 2][m + 2];
		int[][] up = new int[n + 2][m + 2];
		int[][] down = new int[n + 2][m + 2];

		final int INF = 1_000_000_007;

		for (int i = 0; i <= n + 1; i++) {
			Arrays.fill(up[i], -INF);
			Arrays.fill(down[i], -INF);
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		up[n + 1][1] = up[n][0] = 0;
		down[n + 1][m] = down[n][m + 1] = 0;

		for (int i = n; i > 0; i--) {
			for (int j = 1; j <= m; j++) {
				up[i][j] = Math.max(up[i][j - 1], up[i + 1][j]) + map[i][j];
			}

			for (int j = m; j > 0; j--) {
				down[i][j] = Math.max(down[i][j + 1], down[i + 1][j]) + map[i][j];
			}
		}

		int answer = -INF;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				answer = Math.max(answer, up[i][j] + down[i][j]);
			}
		}

		System.out.println(answer);
	}
}