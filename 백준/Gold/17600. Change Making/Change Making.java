import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] coins;
	static int[] dp;
	static final int MAX = 100_001;

	static void init() {
		Arrays.fill(dp, MAX);
		dp[0] = 0;

		for (int c : coins) {
			for (int j = c; j < MAX; j++) {
				dp[j] = Math.min(dp[j], dp[j - c] + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		coins = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[MAX];

		init();

		int c;
		int t;

		int answer = -1;

		for (int i = 1; i < MAX; i++) {
			c = 0;
			t = i;

			// greedy
			for (int j = n - 1; j >= 0; j--) {
				c += t / coins[j];
				t %= coins[j];
			}

			if (dp[i] < c) {
				answer = i;
				break;
			}
		}

		System.out.println(answer);
	}
}