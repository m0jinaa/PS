import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int INF = -1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		int[] brightness = new int[n + 1];
		int[] onOff = new int[n + 1];

		int[][] dp = new int[n + 1][3];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			brightness[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			onOff[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], INF);
		}

		dp[0][0] = 0;

		for (int i = 1; i <= n; i++) {
			dp[i][0] = dp[i - 1][0] + brightness[i] * onOff[i];
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]) + brightness[i] * (1 - onOff[i]);
			dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]) + brightness[i] * onOff[i];
		}
        
		int answer = Math.max(dp[n][1], dp[n][2]);
        
		System.out.println(answer);
	}
}