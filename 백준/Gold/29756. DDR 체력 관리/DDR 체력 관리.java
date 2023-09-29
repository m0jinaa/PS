import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[][] dp;// dp[구간][체력]일때의 최대점수
	static int[][] rounds;

	static int getMax() {

		dp[0][100] = 0;

		int nh, ns;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 101; j++) {
				if (dp[i][j] == -1)
					continue;

				nh = Math.min(j + k, 100);

				// 구간 플레이 x
				dp[i + 1][nh] = Math.max(dp[i + 1][nh], dp[i][j]);

				// 구간 플레이
				nh -= rounds[i + 1][1];
				ns = dp[i][j] + rounds[i + 1][0];

				if (nh < 0)
					continue;

				dp[i + 1][nh] = Math.max(dp[i + 1][nh], ns);
			}
		}
		int answer = 0;
		for (int i = 0; i <= 100; i++) {
			answer = Math.max(answer, dp[n][i]);
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		rounds = new int[n + 1][2];

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				rounds[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[n + 1][101];

		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}

		int answer = getMax();

		System.out.println(answer);
	}
}