import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int INF = 1_000_000_007;
	static int n;
	static char[] phone;
	static int[] dp;

	static int checkTwo(int x) {
		if (phone[x] == phone[x + 1])
			return 2;
		return 0;
	}

	static int checkThree(int x) {
		if (phone[x] == phone[x + 1] && phone[x + 1] == phone[x + 2])
			return 2;
		else if (phone[x] == phone[x + 1] || phone[x + 1] == phone[x + 2] || phone[x] == phone[x + 2])
			return 1;
		else
			return 0;
	}

	static int getMax(int x) {
		if (dp[x] != -1)
			return dp[x];

		int max = -INF;

		max = Math.max(max, checkTwo(x) + getMax(x + 2));

		if (x + 3 <= n) {
			max = Math.max(max, checkThree(x) + getMax(x + 3));
		}

		return dp[x] = max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		phone = br.readLine().toCharArray();
		n = phone.length;

		dp = new int[n + 1];

		Arrays.fill(dp, -1);

		dp[n] = 0;
		dp[n - 1] = -INF;

		getMax(0);

		int i = 0;

		while (i < n) {
			if (dp[i] == dp[i + 2] + checkTwo(i)) {
				sb.append(phone[i]).append(phone[i + 1]);
				i += 2;
			} else if (dp[i] == dp[i + 3] + checkThree(i)) {
				sb.append(phone[i]).append(phone[i + 1]).append(phone[i + 2]);
				i += 3;
			}

			if (i != n)
				sb.append("-");
		}

		System.out.println(sb.toString());
	}
}