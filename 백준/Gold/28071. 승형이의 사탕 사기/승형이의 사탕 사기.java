import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int x;
		final int MAX = 90001;
		int[] dp = new int[MAX];

		Arrays.fill(dp, MAX);

		dp[0] = 0;

		while (n-- > 0) {
			x = Integer.parseInt(st.nextToken());
			for (int i = x; i < MAX; i++) {
				dp[i] = Math.min(dp[i], dp[i - x] + 1);
			}
		}

		int answer = 0;

		for (int i = MAX - 1; i >= 0; i--) {
			if (i % k != 0 || dp[i] > m)
				continue;
			answer = i;
			break;
		}

		System.out.println(answer);
	}
}