import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isPrime;
	static int[] prime;
	static boolean[] isSquare;
	static int[] squarePrime;
	static int N = 1_000_000;

	static void init() {
		isPrime = new boolean[N + 1];
		isSquare = new boolean[N + 1];
		prime = new int[N + 1];
		squarePrime = new int[N + 1];

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;
		isSquare[1] = true;
		int p;

		for (int i = 2; i <= N; i++) {
			prime[i] = prime[i - 1];
			squarePrime[i] = squarePrime[i - 1];

			if (i <= 1000) {
				isSquare[i * i] = true;
			}
			if (!isPrime[i])
				continue;
			prime[i]++;

			p = (int) Math.sqrt(i);

			for (int j = 1; j <= p; j++) {
				if (isSquare[i - j * j]) {
					squarePrime[i]++;
					break;
				}
			}

			if (i > 1000)
				continue;
			for (int j = i * i; j <= N; j += i) {
				isPrime[j] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		init();

		int l, u, p, sp, s, e;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			l = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());

			if (l == -1 && u == -1)
				break;

			if (l <= 0)
				s = 1;
			else
				s = l;

			if (u <= 0)
				e = 1;
			else
				e = u;

			p = prime[e] - prime[s - 1];
			sp = squarePrime[e] - squarePrime[s - 1];

			sb.append(l).append(" ").append(u).append(" ").append(p).append(" ").append(sp).append("\n");
		}

		System.out.print(sb.toString());
	}
}