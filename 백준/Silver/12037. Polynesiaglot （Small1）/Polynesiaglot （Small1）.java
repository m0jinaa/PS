import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int c, v, l;
		long[][] dp;

		final int MOD = 1_000_000_007;

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			c = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			dp = new long[l + 1][2];

			dp[1][0] = c;
			dp[1][1] = v;

			for (int i = 2; i <= l; i++) {
                //자음은 모음 뒤에만 올 수 있음
				dp[i][0] = (dp[i - 1][1] * c) % MOD;
                
                //모음은 자음과 모음 뒤에 올 수 있음
				dp[i][1] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD) * v) % MOD;
			}

            //자음으로 끝나면 안되므로 모음으로 끝나는 경우만 답
			sb.append("Case #").append(t).append(": ").append(dp[l][1]).append("\n");
		}

		System.out.print(sb.toString());
	}
}