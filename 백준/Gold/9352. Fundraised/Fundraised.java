import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		int n, x;

		int[] cost;
		long[] importance;

		long[] dp;

		int c;
		long p, answer;

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			dp = new long[x + 1];

			Arrays.fill(dp, -1);

			dp[0] = 0;

			// 중요도와 비용 입력받기

			st = new StringTokenizer(br.readLine(), " ");

			importance = new long[n];

			for (int i = 0; i < n; i++) {
				importance[i] = Long.parseLong(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");

			cost = new int[n];

			for (int i = 0; i < n; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n; i++) {
				c = cost[i];
				p = importance[i];

				for (int j = 0; j + c <= x; j++) {
					if (dp[j] == -1)
						continue;
					dp[j + c] = Math.max(dp[j + c], dp[j] + p);
				}
			}

			answer = 0;

			for (int i = 0; i <= x; i++) {
				answer = Math.max(answer, dp[i]);
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}