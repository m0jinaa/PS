import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MOD = 1_000_000_007;

		long[] dp = new long[200001];

		for (int i = 3; i <= 200000; i++) {
			dp[i] = (i * (i - 1) * (i - 2) / 6) % MOD;
		}

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] cnt = new int[n + 1];

		int u, v;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			cnt[u]++;
			cnt[v]++;
		}

		long answer = 0;

		for (int i = 1; i <= n; i++) {
			answer = (answer + dp[cnt[i]]) % MOD;
		}

		System.out.println(answer);
	}
}