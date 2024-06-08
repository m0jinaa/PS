import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] ind = new int[1000001];

		int[] dp = new int[n];

		Arrays.fill(ind, -1);

		int x;

		st = new StringTokenizer(br.readLine(), " ");

		int answer = 1;

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());

			dp[i] = 1;
			ind[x] = i;

			if (ind[x - 1] == -1)
				continue;

			dp[i] = Math.max(dp[i], dp[ind[x - 1]] + 1);

			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}
}