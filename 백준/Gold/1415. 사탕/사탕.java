
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static boolean[] isPrime;
	static int MAX;
	static int[] candy;
	static long[] dp;

	static void init() {
		Arrays.fill(isPrime, true);

		isPrime[0] = false;
		
		if (MAX >= 1)
			isPrime[1] = false;
		
		int sqrt = (int) Math.sqrt(MAX);

		for (int i = 2; i <= MAX; i++) {
			if (!isPrime[i] || i > sqrt)
				continue;

			for (int j = i * i; j <= MAX; j += i) {
				isPrime[j] = false;
			}
		}
	}

	static long getCnt() {
		dp[0] = candy[0] + 1;
		candy[0] = 0;
		int x;
		for (int i = 0; i <= 10000; i++) {
			if (candy[i] == 0)
				continue;
			for (int j = MAX; j >= 0; j--) {
				x = i;
				for (int k = 0; k < candy[i]; k++, x += i) {
					if (x > j)
						break;
					dp[j] += dp[j - x];
				}

			}
		}

		long cnt = 0;

		for (int i = 0; i <= MAX; i++) {
			if (!isPrime[i])
				continue;
			cnt += dp[i];
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		candy = new int[10001];

		int x;
		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(br.readLine());
			candy[x]++;

			MAX += x;
		}

		isPrime = new boolean[MAX + 1];
		dp = new long[MAX + 1];

		init();

		long answer = getCnt();

		System.out.println(answer);
	}
}