import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, b;
	static int[] cows;
	static int[] field;
	static int[] dp;
	static final int INF = 1_000_001;

	static void fill() {

		dp[0] = 0;

		for (int x : cows) {
			for (int j = x; j < 100001; j++) {
				dp[j] = Math.min(dp[j], dp[j - x] + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		dp = new int[100001];
		Arrays.fill(dp, INF);

		cows = new int[b];

		for (int i = 0; i < b; i++) {
			cows[i] = Integer.parseInt(br.readLine());
		}

		field = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			field[i] = Integer.parseInt(br.readLine());
		}

		fill();

		int answer = 0;
		int x;
		for (int i = 1; i <= n; i++) {
			if (field[i - 1] == 0)
				x = field[i];
			else
				x = field[i] - field[i - 1] + 1;

			if (x < 0)
				continue;
			if (dp[x] == INF) {
				answer = -1;
				break;
			}

			answer += dp[x];
		}
		System.out.println(answer);
	}
}