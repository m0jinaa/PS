import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isPrime;
	static int[] prime;
	static int ind = 0;

	static void init() {
		isPrime = new boolean[110001];
		prime = new int[11000];

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		int limit = (int) Math.floor(Math.sqrt(110000));
		for (int i = 2; i < 110001; i++) {

			if (!isPrime[i])
				continue;

			prime[ind++] = i;

			if (i > limit)
				continue;

			for (int j = i * i; j < 110001; j += i) {
				isPrime[j] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		init();

		int n = Integer.parseInt(br.readLine());

		System.out.println(prime[n - 1]);

	}
}