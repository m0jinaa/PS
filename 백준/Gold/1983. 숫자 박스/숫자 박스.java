import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, a, b;
	static int[] A, B;
	static int[][][] dp;
	static final int INF = -1_000_000_007;

	static int getMax(int i, int j, int k) {
		if (i == a || j == b)
			return dp[i][j][k] = 0;
		if (dp[i][j][k] != INF)
			return dp[i][j][k];
		int max = INF;

		max = Math.max(max, A[i] * B[j] + getMax(i + 1, j + 1, k + 1));

		if (a - i + k < n) {
			max = Math.max(max, getMax(i, j + 1, k + 1));
		}

		if (b - j + k < n) {
			max = Math.max(max, getMax(i + 1, j, k + 1));
		}

		return dp[i][j][k] = max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		A = new int[n];
		B = new int[n];

		int x;

		a = 0;

		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			x = Integer.parseInt(st.nextToken());
			if (x == 0)
				continue;
			A[a++] = x;
		}

		b = 0;

		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			x = Integer.parseInt(st.nextToken());
			if (x == 0)
				continue;
			B[b++] = x;
		}

		dp = new int[a + 1][b + 1][n + 1];

		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				Arrays.fill(dp[i][j], INF);
			}
		}

		int answer = getMax(0, 0, 0);

		System.out.println(answer);
	}
}