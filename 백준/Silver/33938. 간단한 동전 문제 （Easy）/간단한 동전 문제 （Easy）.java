import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int ADJUSTMENT = 10_000;
		final int MAX = 10_000;
		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] coins = new int[n];

		if (n != 0)
			st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[MAX + 1 + ADJUSTMENT];

		Arrays.fill(dp, INF);

		LinkedList<Integer> q = new LinkedList<>();

		q.add(0);
		dp[ADJUSTMENT] = 0;

		int now;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now == m) {
				answer = dp[now + ADJUSTMENT];
				break;
			}

			for (int c : coins) {
				if (now + c < -MAX || now + c > MAX || dp[now + c + ADJUSTMENT] != INF)
					continue;
				dp[now + c + ADJUSTMENT] = dp[now + ADJUSTMENT] + 1;
				q.add(now + c);
			}
		}

		System.out.println(answer);
	}
}