import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());

		int[] dp = new int[101];

		Arrays.fill(dp, -1);

		dp[x] = 0;

		for (int i = 1; i < n; i++) {
			x = Integer.parseInt(st.nextToken());

			for (int j = 1; j < 101; j++) {
				if (dp[j] == -1)
					continue;
				dp[x] = Math.max(dp[x], dp[j] + (x - j) * (x - j));
			}
		}

		int answer = 0;

		for (int i = 1; i < 101; i++) {
			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}
}