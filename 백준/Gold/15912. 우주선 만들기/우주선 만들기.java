import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long[] dp = new long[n + 1];

		long[][] maxEnergy = new long[n + 1][n + 1];
		long[][] maxWeight = new long[n + 1][n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			maxWeight[i][i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			maxEnergy[i][i] = Long.parseLong(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] + maxWeight[i][i] * maxEnergy[i][i];

			for (int j = i - 1; j > 0; j--) {
				maxWeight[j][i] = Math.max(maxWeight[j][i - 1], maxWeight[i][i]);
				maxEnergy[j][i] = Math.max(maxEnergy[j][i - 1], maxEnergy[i][i]);

				dp[i] = Math.min(dp[i], dp[j - 1] + maxWeight[j][i] * maxEnergy[j][i]);
			}
		}

		System.out.println(dp[n]);
	}
}