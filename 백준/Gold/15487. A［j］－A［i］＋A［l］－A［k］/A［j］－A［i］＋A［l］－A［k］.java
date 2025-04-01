import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = -1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int a;

		int[] dp = new int[5];

		Arrays.fill(dp, INF);

		dp[0] = 0;

		int m;

		for (int i = 1; i <= n; i++) {
			a = Integer.parseInt(st.nextToken());

			m = Math.min(i, 4);

			// 반대방향으로 해야 중복 안됨.
			for (int j = m; j > 0; j--) {
				if (j % 2 != 0) {
					dp[j] = Math.max(dp[j], dp[j - 1] - a);
				} else {
					dp[j] = Math.max(dp[j], dp[j - 1] + a);
				}
			}
		}

		System.out.println(dp[4]);
	}
}