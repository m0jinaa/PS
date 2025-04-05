import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] hay;
	static long[][] dp;

	static long getMax(int s, int e, int d) {
		if (s > e)
			return 0;
		else if (dp[s][e] != 0)
			return dp[s][e];

		long max = 0;

		max = Math.max(hay[s] * d + getMax(s + 1, e, d + 1), hay[e] * d + getMax(s, e - 1, d + 1));

		return dp[s][e] = max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		hay = new long[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			hay[i] = Integer.parseInt(st.nextToken());
		}

		dp = new long[n][n];

		long answer = getMax(0, n - 1, 1);

		System.out.println(answer);
	}
}