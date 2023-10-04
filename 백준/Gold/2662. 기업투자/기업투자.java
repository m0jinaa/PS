import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

	static int[] dp;
	static int[][] before;
	static int[][] invest;
	static int[] money;

	static int getMax() {
		int p;
		for (int i = 1; i <= m; i++) {
			for (int j = n; j >= 0; j--) {
				for (int k = 1; k <= n; k++) {
					if (j - k < 0)
						break;
					p = dp[j - k] + invest[i][k];
					if (dp[j] < p) {
						before[i][j] = j - k;
						dp[j] = p;
					} else if (before[i][j] == 0 && i != 1) {
						before[i][j] = j;
					}
				}
			}
		}

		int x = n;
		for (int i = m; i >= 1; i--) {
			money[i] = x - before[i][x];
			x = before[i][x];
		}
		return dp[n];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dp = new int[n + 1];

		before = new int[m + 1][n + 1];

		invest = new int[m + 1][n + 1];

		money = new int[m + 1];

		int p;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			p = Integer.parseInt(st.nextToken());

			for (int j = 1; j <= m; j++) {
				invest[j][p] = Integer.parseInt(st.nextToken());
			}
		}

		int profit = getMax();

		sb.append(profit).append("\n");

		for (int i = 1; i <= m; i++) {
			sb.append(money[i]).append(i == m ? "\n" : " ");
		}

		System.out.print(sb.toString());

	}
}