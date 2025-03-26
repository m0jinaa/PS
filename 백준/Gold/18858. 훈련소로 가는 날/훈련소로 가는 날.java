import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static final int MOD = 998_244_353;
	static long[][][] dp;

	static long getCnt(int x, int v, int u) {
		if (x == n)
			return dp[x][v][u] = 1;
		else if (dp[x][v][u] != -1)
			return dp[x][v][u];

		long cnt = 0;

		// 유지&상승
		if (v != 0)
			cnt = (cnt + getCnt(x + 1, v, 0)) % MOD;

		for (int i = v + 1; i <= m; i++) {
			cnt = (cnt + getCnt(x + 1, i, v == 0 ? 0 : 1)) % MOD;
		}

		// 상승하지 않을 때만 하강 가능
		if (u == 0) {
			for (int i = v - 1; i > 0; i--) {
				cnt = (cnt + getCnt(x + 1, i, u)) % MOD;
			}
		}

		return dp[x][v][u] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dp = new long[n + 1][m + 1][2];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		long answer = getCnt(0, 0, 0);

		System.out.println(answer);
	}
}