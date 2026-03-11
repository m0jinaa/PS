import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int[] grade = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			grade[i] = Integer.parseInt(st.nextToken());
		}

		long[][] dp = new long[n + 1][2];

		for (int i = 1; i <= n; i++) {
			if (grade[i] == m) {
				dp[i][0] = 0;
			} else {
				dp[i][0] = dp[i - 1][0] + 1;
			}
			dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
		}

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		while (q-- > 0) {
			x = Integer.parseInt(st.nextToken());

			sb.append(dp[x][0] + dp[x][1]).append("\n");
		}

		System.out.print(sb.toString());
	}
}