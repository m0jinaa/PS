import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int MAX = 1_00_000;
	static boolean[] isPrime;

	static void init() {
		isPrime = new boolean[MAX + 1];

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		int limit = (int) Math.sqrt(MAX);

		for (int i = 2; i <= MAX; i++) {
			if (!isPrime[i])
				continue;
			if (i > limit)
				continue;

			for (int j = i * i; j <= MAX; j += i) {
				isPrime[j] = false;
			}
		}
	}

	static int maxDivider(int x) {

		int max = 1;

		for (int i = 2; i <= x; i++) {
			if (!isPrime[i] || x % i != 0)
				continue;
			max = Math.max(max, i);

			while (x % i == 0)
				x /= i;
		}

		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		init();

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int answer = 0;
		int ret;

		for (int i = 1; i <= n; i++) {
			ret = maxDivider(i);
			if (ret > k)
				continue;
			answer++;
		}

		System.out.println(answer);
    }
}