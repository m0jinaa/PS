import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		int n;

		double[] dp;

		double p;

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			dp = new double[n + 1];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= n; i++) {
				p = Double.parseDouble(st.nextToken());
				if (i < 3) {
					dp[i] = Math.max(p, dp[i - 1]);
				} else {
					dp[i] = Math.max(dp[i - 3] + p, dp[i - 1]);
				}
			}

			sb.append(String.format("%.01f\n", dp[n]));
		}

		System.out.print(sb.toString());
	}
}