import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean[] isPrime;
	static int[] prime;
	static int ind = 0;

	static void init() {
		isPrime = new boolean[119];
		prime = new int[30];

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < 119; i++) {

			if (!isPrime[i])
				continue;

			prime[ind++] = i;

			for (int j = i * i; j < 119; j += i) {
				isPrime[j] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();

		int n = Integer.parseInt(br.readLine());

		int a;
		boolean possible;
		while (n-- > 0) {
			a = Integer.parseInt(br.readLine());

			possible = false;

			for (int p : prime) {
				if (a - p < p)
					break;
				if (!isPrime[a - p])
					continue;
				possible = true;
				break;
			}

			sb.append(possible ? "Yes\n" : "No\n");
		}

		System.out.println(sb.toString());
	}
}