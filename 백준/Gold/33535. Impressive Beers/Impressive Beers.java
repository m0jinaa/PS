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

		int[] dp = new int[m + 1];

		int p, h;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			for (int i = m; i >= p; i--) {
				dp[i] = Math.max(dp[i], dp[i - p] + h);
			}
		}

		System.out.println(dp[m]);
	}
}