import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static long[] dp;
	static int n;
	static final int MOD = 987_654_321;

	static long getCnt(int x) {
		if (x % 2 != 0) {
			return dp[x] = 0;
		} else if (dp[x] != -1) {
			return dp[x];
		}

		long cnt = 0;

		int a = 0;
		int b = x - 2;

		while (b >= 0) {
			cnt = (cnt + (getCnt(a) * getCnt(b))%MOD) % MOD;
			a += 2;
			b -= 2;
		}

		return dp[x] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		dp = new long[n + 1];

		Arrays.fill(dp, -1);

		dp[0] = dp[2] = 1L;

		long answer = getCnt(n);

		System.out.println(answer);
	}
}