import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int c0 = Integer.parseInt(st.nextToken());
		int d0 = Integer.parseInt(st.nextToken());

		int[] dp = new int[n + 1];

		// 스페셜 만두 처리
		for (int i = c0; i <= n; i++) {
			dp[i] = dp[i - c0] + d0;
		}

		int a, b, c, d;

		int cnt;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			for (int i = n; i >= 0; i--) {
				cnt = Math.min(i / c, a / b);

				for (int j = 1; j <= cnt; j++) {
					dp[i] = Math.max(dp[i], dp[i - j * c] + j * d);
				}
			}
		}

		System.out.println(dp[n]);
	}
}