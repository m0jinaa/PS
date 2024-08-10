import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int a, b, c, d, e, f;
		int af, bd, ce;

		int[][] dp = new int[n + 1][7];

		// i번째 주사위의 윗면이 ?일때
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			f = Integer.parseInt(st.nextToken());

			af = Math.max(Math.max(b, c), Math.max(d, e));
			bd = Math.max(Math.max(a, c), Math.max(f, e));
			ce = Math.max(Math.max(b, a), Math.max(d, f));

			dp[i][a] = dp[i - 1][f] + af;
			dp[i][b] = dp[i - 1][d] + bd;
			dp[i][c] = dp[i - 1][e] + ce;
			dp[i][d] = dp[i - 1][b] + bd;
			dp[i][e] = dp[i - 1][c] + ce;
			dp[i][f] = dp[i - 1][a] + af;
		}

		int answer = 0;

		for (int i = 1; i < 7; i++) {
			answer = Math.max(answer, dp[n][i]);
		}

		System.out.println(answer);
	}
}