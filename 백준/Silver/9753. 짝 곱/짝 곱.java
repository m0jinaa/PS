import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static final int MAX = 100000;
	static boolean[] isPrime;
	static Set<Integer> prime;

	static void init() {
		isPrime = new boolean[MAX + 1];
		prime = new HashSet<>();

		int limit = (int) Math.floor(Math.sqrt(MAX));

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= MAX; i++) {
			if (!isPrime[i])
				continue;

			prime.add(i);

			if (i > limit)
				continue;
			for (int j = i * i; j <= MAX; j += i)
				isPrime[j] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();

		int t = Integer.parseInt(br.readLine());

		int k;

		while (t-- > 0) {
			k = Integer.parseInt(br.readLine());

			end: while (true) {
				for (int p : prime) {
					if (k % p == 0 && p < k / p && isPrime[k / p]) {
						sb.append(k).append("\n");
						break end;
					}
				}
				k++;
			}
		}

		System.out.print(sb.toString());
	}
}