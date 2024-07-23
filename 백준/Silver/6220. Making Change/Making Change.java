import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] dp = new int[c + 1];

		Arrays.fill(dp, -1);

		dp[0] = 0;

		int x;

		while (n-- > 0) {
			x = Integer.parseInt(br.readLine());

			for (int i = x; i <= c; i++) {
				if (dp[i - x] == -1)
					continue;
				else if (dp[i] == -1)
					dp[i] = dp[i - x] + 1;
				else
					dp[i] = Math.min(dp[i], dp[i - x] + 1);
			}
		}

		System.out.println(dp[c]);
	}
}