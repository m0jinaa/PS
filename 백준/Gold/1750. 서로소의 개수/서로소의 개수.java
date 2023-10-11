import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, MAX;
	static int[] nums;
	static int[][] dp;
	static final int MOD = 10_000_003;

	static int gcd(int x, int y) {
		int t;
		if (x < y) {
			t = x;
			x = y;
			y = t;
		}

		while (y != 0) {
			t = x % y;
			x = y;
			y = t;
		}

		return x;
	}

	static int fill() {
		int v;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= MAX; j++) {
				dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
				v = gcd(j, nums[i]);

				dp[i][v] = (dp[i][v] + dp[i - 1][j]) % MOD;
			}
		}

		return dp[n][1];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		nums = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			MAX = Math.max(MAX, nums[i]);
		}

		dp = new int[n + 1][MAX + 1];// dp[i][j] = i번째 숫자까지 봤을 때 최대공약수가 j인 집합의 개수

		for (int i = 1; i <= n; i++) {
			dp[i][nums[i]] = 1;
		}

		System.out.println(fill());
	}
}