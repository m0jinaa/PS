import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] cows;
	static boolean[][] dp;
	static boolean[] isPrime;

	static void init() {
		isPrime = new boolean[10001];

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= 10000; i++) {
			if (!isPrime[i] || i > 100)
				continue;
			for (int j = i * i; j <= 10000; j += i)
				isPrime[j] = false;
		}
	}

	static void getAnswer() {

		dp[0][0] = true;

		for (int c : cows) {
			for (int i = m - 1; i >= 0; i--) {
				for (int j = 0; j <= 10000; j++) {
					if (c + j > 10000)
						break;
					else if (!dp[i][j])
						continue;
					dp[i + 1][j + c] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		init();

		cows = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}

		dp = new boolean[m + 1][10001];

		getAnswer();

		for (int i = 2; i <= 10000; i++) {
			if (!isPrime[i] || !dp[m][i])
				continue;

			sb.append(i).append(" ");
		}

		System.out.println(sb.length() == 0 ? -1 : sb.toString());
	}
}