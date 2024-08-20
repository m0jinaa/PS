import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isPrime;
	static final int MAX = 1_000_000;

	static void init() {
		isPrime = new boolean[MAX + 1];

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= MAX; i++) {
			if (!isPrime[i] || i > 1000)
				continue;

			for (int j = i * i; j <= MAX; j += i)
				isPrime[j] = false;

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		init();

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		long answer = 1L;

		int x;
		boolean[] found = new boolean[MAX + 1];

		while (n-- > 0) {
			x = Integer.parseInt(st.nextToken());

			if (!isPrime[x] || found[x])
				continue;
			answer *= x;
			found[x] = true;
		}

		System.out.println(answer == 1L ? -1 : answer);
	}
}