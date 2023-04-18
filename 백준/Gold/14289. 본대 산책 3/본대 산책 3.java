import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;
	static int n;

	static long[][] mult(long[][] a, long[][] b) {
		long[][] c = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					c[i][j] += a[i][k] * b[k][j];
					c[i][j] %= MOD;
				}
			}
		}
		return c;
	}

	static long[][] pow(long[][] x, int d) {
		if (d == 1)
			return x;
		else {
			long[][] nx = pow(x, d / 2);
			long[][] ans = mult(nx, nx);

			if (d % 2 == 0) {
				return ans;
			} else {
				return mult(ans, x);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[][] matrix = new long[n][n];

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;

			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}

		int d = Integer.parseInt(br.readLine());

		long[][] ans = pow(matrix, d);

		System.out.println(ans[0][0]);
	}
}