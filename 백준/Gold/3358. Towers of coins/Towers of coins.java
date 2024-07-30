import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());

		boolean[] dp = new boolean[1000001];

		for (int i = 1; i < 1000001; i++) {
			dp[i] |= (!dp[i - 1]);
			if (i >= k) {
				dp[i] |= (!dp[i - k]);
			}
			if (i >= l) {
				dp[i] |= (!dp[i - l]);
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		while (m-- > 0) {
			x = Integer.parseInt(st.nextToken());

			sb.append(dp[x] ? "A" : "B");
		}

		System.out.println(sb.toString());
	}
}