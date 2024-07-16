import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static long[] dp;

	static long getCnt(int x, int p) {
		if (dp[p] != -1)
			return dp[p];
		else if (x == n)
			return dp[p] = 1;

		long cnt = 0;

		int r;

		for (int i = 0; i < n; i++) {
			r = 1 << i;

			if ((p & r) != 0)
				continue;
			if (x < k && i == x) {
				continue;
			}
			cnt += (getCnt(x + 1, p | r));
		}

		return dp[p] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int t;
		long answer;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			t = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			dp = new long[1 << n];

			Arrays.fill(dp, -1);

			answer = getCnt(0, 0);

			sb.append(t).append(" ").append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}