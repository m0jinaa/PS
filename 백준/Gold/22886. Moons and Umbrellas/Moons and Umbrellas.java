import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int x, y, n;
	static char[] mural;
	static int[] dp;
	static final int INF = 1_000_000_007;

	static int getMin() {
		int c, j;
		dp = new int[2];
		Arrays.fill(dp, INF);

		if (mural[0] != 'J') // c 또는 ?
			dp[0] = 0;

		if (mural[0] != 'C') // j 또는 ?
			dp[1] = 0;

		for (int i = 1; i < n; i++) {
			c = dp[0];
			j = dp[1];

			Arrays.fill(dp, INF);

			if (mural[i] != 'J') {
				dp[0] = Math.min(c, j + y);
			}
			if (mural[i] != 'C') {
				dp[1] = Math.min(j, c + x);
			}
		}

		return Math.min(dp[0], dp[1]);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int cost;
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			mural = st.nextToken().toCharArray();

			n = mural.length;

			cost = getMin();

			sb.append("Case #").append(t).append(": ").append(cost).append("\n");
		}

		System.out.print(sb.toString());
	}
}