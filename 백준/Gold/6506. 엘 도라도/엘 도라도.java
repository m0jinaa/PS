import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n, k;
		int[] nums;
		long[][] dp;
		long answer;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			if (n == 0 && k == 0)
				break;

			nums = new int[n];

			st = new StringTokenizer(br.readLine(), " ");

			dp = new long[n][k + 1];

			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				dp[i][1] = 1;
			}

			for (int i = 1; i < n; i++) {
				for (int j = i - 1; j >= 0; j--) {
					if (nums[i] <= nums[j])
						continue;
					for (int u = 2; u <= k; u++) {
						dp[i][u] += dp[j][u - 1];
					}
				}
			}

			answer = 0;

			for (int i = 0; i < n; i++) {
				answer += dp[i][k];
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}