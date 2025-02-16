import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int n;
	static int[] sum, num, dp;

	static void init() {
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + num[i];
		}

		Arrays.fill(dp, -INF);
		dp[n + 1] = 0;
	}

	static int getBest(int x) {
		if (dp[x] != -INF)
			return dp[x];

		int diff = INF;

		for (int i = x; i <= n; i++) {
			diff = Math.min(diff, sum[i] - sum[x - 1] - getBest(i + 1));
		}

		return dp[x] = diff;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		int tc = 3;

		int diff;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			sum = new int[n + 1];
			num = new int[n + 1];

			for (int i = n; i > 0; i--) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			dp = new int[n + 2];

			init();

			diff = getBest(1);

			sb.append(diff < 0 ? "A" : diff > 0 ? "B" : "D").append("\n");
		}

		System.out.println(sb.toString());
	}
}