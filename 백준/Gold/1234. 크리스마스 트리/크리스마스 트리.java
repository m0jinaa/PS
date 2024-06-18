import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[][][] dp;
	static int[] fact = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800 };

	static int[][] dx = new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 0 }, { 1, 0, 1 }, { 0, 1, 1 },
			{ 1, 1, 1 } };

	static long getCnt(int l, int r, int b, int g) {
		if (l == n + 1)
			return 1;
		else if (dp[l][r][b] != -1)
			return dp[l][r][b];

		long ret = 0;

		int nr, nb, ng, dr, db, dg;

		int t;
		for (int i = 0; i < 7; i++) {
			t = (i / 3) + 1;

			if (l % t != 0)
				continue;

			dr = dx[i][0] * l / t;
			db = dx[i][1] * l / t;
			dg = dx[i][2] * l / t;

			nr = r - dr;
			nb = b - db;
			ng = g - dg;

			if (nr < 0 || nb < 0 || ng < 0)
				continue;

			ret += fact[l] / (fact[dr] * fact[db] * fact[dg]) * getCnt(l + 1, nr, nb, ng);
		}
        
		return dp[l][r][b] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());

		int r = Math.min(55, Integer.parseInt(st.nextToken()));
		int b = Math.min(55, Integer.parseInt(st.nextToken()));
		int g = Math.min(55, Integer.parseInt(st.nextToken()));

		dp = new long[n + 1][r + 1][b + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= r; j++)
				Arrays.fill(dp[i][j], -1);
		}
		long answer = getCnt(1, r, b, g);

		System.out.println(answer);
	}
}