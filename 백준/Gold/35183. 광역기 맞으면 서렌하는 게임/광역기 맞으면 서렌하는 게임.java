import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int MAX = 1000;

		int n = Integer.parseInt(br.readLine());

		boolean[][][] exists = new boolean[n + 1][2][MAX + 1];
		Arrays.fill(exists[0][0], true);

		int l = -1, r = -1;
		int s, e;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			for (int j = 0; j <= MAX; j++) {
				s = Math.max(0, j - 1);
				e = Math.min(MAX, j + 1);

				for (int k = s; k <= e; k++) {
					exists[i + 1][0][k] |= exists[i][0][j] && (l <= k && k <= r);
					exists[i + 1][1][k] |= (exists[i][0][j]) || (exists[i][1][j] && (l <= k && k <= r));
				}
			}
		}

		boolean survive = false;

		for (int i = 0; i <= MAX; i++) {
			survive |= exists[n][0][i] || exists[n][1][i];
		}

		System.out.println(survive ? "World Champion\n" : "Surrender\n");
	}
}