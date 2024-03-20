import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[][] dp;
	static int n, k;
	static final int MOD = 1_000_000_000;

	static long getCnt(int x, int c) {
		if (dp[x][c] != -1)
			return dp[x][c];
		else if (c == 1 || x == 0)
			return dp[x][c] = 1;

		long cnt = (getCnt(x, c - 1) + getCnt(x - 1, c)) % MOD;

		return dp[x][c] = cnt;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new long[n + 1][k + 1];

		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}

		long answer = getCnt(n, k);

		System.out.println(answer);
	}
}