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

		int[] time = new int[n + 1];
		int x;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(br.readLine());

			time[i] = time[i - 1] + x;
		}

		int[] dp = new int[n + 1];

		Arrays.fill(dp, 1_000_000_007);

		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + time[j] + 2 * m);
			}
		}

		System.out.println(dp[n] - m);
	}
}