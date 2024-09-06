import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean[] isPrime;
	static int[] prime;
	static int ind = 0;

	static void init() {
		isPrime = new boolean[10001];
		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;
		prime = new int[1230];

		for (int i = 2; i <= 10000; i++) {
			if (!isPrime[i])
				continue;
			prime[ind++] = i;

			if (i > 100)
				continue;
			for (int j = i * i; j <= 10000; j += i)
				isPrime[j] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		init();

		int n = Integer.parseInt(br.readLine());

		int answer = -1;

		for (int i = 0; i < 1229; i++) {
			if (prime[i] * prime[i + 1] > n) {
				answer = prime[i] * prime[i + 1];
				break;
			}
		}

		System.out.println(answer);
	}
}