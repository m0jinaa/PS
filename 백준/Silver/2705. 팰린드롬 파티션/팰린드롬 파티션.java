import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static long[] dp;

	static long getCnt(int x) {
		if (dp[x] != -1)
			return dp[x];
		int y = x / 2;

		long cnt = 1;

		for (int i = 1; i <= y; i++) {
			cnt += getCnt(i);
		}

		return dp[x] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		int n;

		dp = new long[1001];
		Arrays.fill(dp, -1);
		dp[0] = dp[1] = 1;

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());

			sb.append(getCnt(n)).append("\n");
		}

		System.out.print(sb.toString());
	}
}