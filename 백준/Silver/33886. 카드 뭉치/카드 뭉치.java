import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] cards;
	static int[] dp;

	static int getMin(int x) {
		if (x == n) {
			return 0;
		} else if (dp[x] != -1)
			return dp[x];
		int c = n - x;

		for (int i = x + 1; i <= x + cards[x] && i <= n; i++) {
			c = Math.min(c, getMin(i) + 1);
		}

		return dp[x] = c;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		cards = new int[n];
		dp = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			dp[i] = -1;
		}

		int answer = getMin(0);

		System.out.println(answer);
	}
}