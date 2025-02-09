import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int n, l1, l2, s1, s2, answer;

		int[][] dp;
		int[][][] diff;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken()) - 1;
			l1 = Integer.parseInt(st.nextToken());
			l2 = Integer.parseInt(st.nextToken());
			s1 = Integer.parseInt(st.nextToken());
			s2 = Integer.parseInt(st.nextToken());

			diff = new int[2][n][2];

			for (int i = 0; i < 2; i++) {

				// 패스 난이도
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < n; j++) {
					diff[i][j][1] = Integer.parseInt(st.nextToken());
				}

				// 드리블 난이도
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < n; j++) {
					diff[i][j][0] = Integer.parseInt(st.nextToken());
				}
			}

			dp = new int[2][n + 1];

			Arrays.fill(dp[0], Integer.MAX_VALUE);
			Arrays.fill(dp[1], Integer.MAX_VALUE);

			dp[0][0] = l1;
			dp[1][0] = l2;

			for (int j = 0; j < n; j++) {
				for (int i = 0; i < 2; i++) {
					for (int k = 0; k < 2; k++) {
						dp[(i + k) % 2][j + 1] = Math.min(dp[(i + k) % 2][j + 1], dp[i][j] + diff[i][j][k]);
					}
				}
			}

			answer = Math.min(dp[0][n] + s1, dp[1][n] + s2);

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}