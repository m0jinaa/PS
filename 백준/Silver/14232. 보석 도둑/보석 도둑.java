import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static Set<Long> prime;
	static Set<Long> notPrime;

	static boolean isPrime(long k) {
		if (prime.contains(k))
			return true;
		else if (notPrime.contains(k))
			return false;

		int limit = (int) Math.floor(Math.sqrt(k));

		for (int i = 2; i <= limit; i++) {
			if (k % i == 0) {
				notPrime.add(k);
				return false;
			}
		}

		prime.add(k);

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long k = Long.parseLong(br.readLine());

		prime = new HashSet<>();
		notPrime = new HashSet<>();

		long p = 2;
		int c = 0;

		while (k != 1) {
			if (isPrime(k)) {
				c++;
				sb.append(k);
				break;
			}
			while (k % p == 0) {
				c++;
				sb.append(p).append(" ");
				k /= p;
			}
			p++;
		}

		System.out.println(c);
		System.out.println(sb.toString());

	}
}