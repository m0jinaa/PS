import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] switches;
	static long[] dp;
	static int n, m;
	static final long INF = 1_000_000_000_000_001L;

	static long getMin() {
		dp[0] = 0;
		
		for (int[] s : switches) {
			for (int j = m - s[0] + 2; j >= 1; j--) {
				if (dp[j] == INF)
					continue;
				dp[j + s[0] - 2] = Math.min(dp[j + s[0] - 2], dp[j] + s[1]);
			}

			if (s[0] - 1 <= m) {
				dp[s[0] - 1] = Math.min(dp[s[0] - 1], s[1]);
			}
		}

		return dp[m];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		switches = new int[n][2];

		int a, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			switches[i][0] = a;
			switches[i][1] = b;
		}

		m = Integer.parseInt(br.readLine());

		dp = new long[m + 1];

		Arrays.fill(dp, INF);
		long answer;
		if (m == 1)
			answer = 0;
		else
			answer = getMin();

		System.out.println(answer == INF ? -1 : answer);
	}
}