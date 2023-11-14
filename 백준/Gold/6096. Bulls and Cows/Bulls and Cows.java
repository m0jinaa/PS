import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 5_000_011;

	static int n, k;
	static int[] dp;

	static int getCnt(int x) {
		if (x >= n)
			return 1;
		else if (dp[x] != -1)
			return dp[x];
		else if (x == n - 1)
			return dp[x] = 2;
		int cnt = 0;

		cnt = (getCnt(x + 1) + getCnt(x + k + 1)) % MOD;

		return dp[x] = cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new int[n];

		Arrays.fill(dp, -1);

		int answer = getCnt(0);

		System.out.println(answer);
	}
}