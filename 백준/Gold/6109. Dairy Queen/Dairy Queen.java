import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int x;

		int[] dp = new int[n + 1];

		dp[0] = 1;

		while (c-- > 0) {
			x = Integer.parseInt(br.readLine());

			for (int i = x; i <= n; i++) {
				dp[i] += dp[i - x];
			}
		}

		System.out.println(dp[n]);
	}
}