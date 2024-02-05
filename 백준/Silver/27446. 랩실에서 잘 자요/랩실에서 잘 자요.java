import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] dp = new int[n + 1];
		final int INF = 1_000_000_007;
		Arrays.fill(dp, INF);

		boolean[] page = new boolean[n + 1];

		st = new StringTokenizer(br.readLine(), " ");
		int x;
		while (m-- > 0) {
			x = Integer.parseInt(st.nextToken());
			page[x] = true;
		}

		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			if (page[i]) {
				dp[i] = dp[i - 1];
				continue;
			}

			for (int j = 1; j <= i; j++) {
				if (page[j])
					continue;
				dp[i] = Math.min(dp[i], dp[j - 1] + 5 + (i - j + 1) * 2);
			}
		}

		System.out.println(dp[n]);
	}
}