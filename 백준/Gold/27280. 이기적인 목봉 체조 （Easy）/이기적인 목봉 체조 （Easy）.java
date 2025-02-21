import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[][] dp = new long[n + 1][m + 1];

		int s, h;

		int[] height = new int[n + 1];
		long[] strength = new long[n + 1];

		int maxH;
		long maxS;
		int maxM;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			h = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			maxH = h;
			maxS = s;
			for (int j = i; j > 0; j--) {

				// j번째~i번째가 같은 그룸일 때 목봉무게 찾기

				if (height[j] > maxH) {
					maxH = height[j];
					maxS = strength[j];
				} else if (height[j] == maxH) {
					maxS += strength[j];
				}
				maxM = Math.min(j, m);

				for (int k = 2; k <= maxM; k++) {
					dp[i][k] = Math.max(dp[i][k], dp[j - 1][k - 1] + maxS);
				}
			}
			dp[i][1] = maxS;

			height[i] = h;
			strength[i] = s;
		}

		System.out.println(dp[n][m]);
	}
}