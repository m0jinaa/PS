import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k, p;
	static int[][] dp;
	static int[][] stacks;

	static int getMax() {
		dp[1][0] = 0;
		dp[0][0] = 0;
		int b, c;
		int ind = 0;
		for (int i = 0; i < n; i++) {
			b = 0;
			for (int j = 0; j < k; j++) {
				b += stacks[i][j];
				c = j + 1;

				for (int w = p; w >= c; w--) {
					dp[ind][w] = Math.max(dp[ind][w], dp[1 - ind][w]);

					if (dp[1 - ind][w - c] == -1)
						continue;
					dp[ind][w] = Math.max(dp[ind][w], dp[1 - ind][w - c] + b);
				}
			}
			ind = 1 - ind;
		}

		return dp[1 - ind][p];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());

			dp = new int[2][p + 1];

			Arrays.fill(dp[0], -1);
			Arrays.fill(dp[1], -1);

			stacks = new int[n][k];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < k; j++) {
					stacks[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("Case #").append(t).append(": ").append(getMax()).append("\n");
		}

		System.out.print(sb.toString());
	}
}