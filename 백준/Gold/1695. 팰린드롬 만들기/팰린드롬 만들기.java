import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int n;
	static int[] nums;

	static int getMin(int s, int e) {
		if (e < s)
			return 0;
		if (dp[s][e] != -1)
			return dp[s][e];
		else if (s == e)
			return dp[s][e] = 0;

		int cnt = n + 1;

		if (nums[s] != nums[e]) {
			cnt = Math.min(cnt, getMin(s + 1, e) + 1);
			cnt = Math.min(cnt, getMin(s, e - 1) + 1);
		} else {
			cnt = Math.min(cnt, getMin(s + 1, e - 1));
		}

		return dp[s][e] = cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		nums = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1);
		}

		int answer = getMin(0, n - 1);

		System.out.println(answer);
	}
}