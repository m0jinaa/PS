import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] boost;
	static int[][] dp;

	static int getMax(int t, int x, int c) {
		if (dp[t][x] != -1)
			return dp[t][x];
		else if (t == 0) {
			return dp[t][x] = 0;
		}

		int max = x + getMax(t - 1, x, c + x);

		for (int[] button : boost) {
			if (c < button[0])
				continue;
			max = Math.max(max, getMax(t - 1, x + button[1], c - button[0]) - button[0]);
		}

		return dp[t][x] = max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boost = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			boost[i][0] = Integer.parseInt(st.nextToken());
			boost[i][1] = Integer.parseInt(st.nextToken());
		}

		dp = new int[k + 1][6000];

		for (int i = 0; i <= k; i++) {
			Arrays.fill(dp[i], -1);
		}
		int answer = getMax(k, 1, 0);

		System.out.println(answer);
	}
}