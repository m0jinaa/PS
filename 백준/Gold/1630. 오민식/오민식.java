import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean[] isPrime;

	public static void init() {
		isPrime = new boolean[1000001];

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		int limit = (int) Math.floor(Math.sqrt(1000000));

		for (int i = 2; i < 1000001; i++) {
			if (!isPrime[i] || i > limit)
				continue;

			for (int j = i * i; j < 1000001; j += i)
				isPrime[j] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		init();

		final int MOD = 987_654_321;
		int n = Integer.parseInt(br.readLine());

		long answer = 1;

		long p;

		for (int i = 2; i <= n; i++) {
			if (!isPrime[i])
				continue;
			p = i;
			while (p * i <= n) {
				p *= i;
			}

			answer = (answer * p) % MOD;
		}

		System.out.println(answer);
	}
}