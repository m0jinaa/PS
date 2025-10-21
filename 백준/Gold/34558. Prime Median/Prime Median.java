import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 1_000_000;
	static final int CNT = 78_498;
	static int[] prime;
	static boolean[] isPrime;

	static void init() {
		isPrime = new boolean[MAX + 1];
		prime = new int[CNT];

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		int limit = (int) Math.sqrt(MAX);

		int ind = 0;

		for (int i = 2; i <= MAX; i++) {
			if (!isPrime[i])
				continue;

			prime[ind++] = i;

			if (i > limit)
				continue;

			for (int j = i * i; j <= MAX; j += i) {
				isPrime[j] = false;
			}
		}
	}

	static int getLeft(int x) {
		int s = 0;
		int e = CNT - 1;
		int m;

		int ans = CNT;

		while (s <= e) {
			m = (s + e) / 2;

			if (prime[m] >= x) {
				ans = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		return ans;
	}

	static int getRight(int x) {
		int s = 0;
		int e = CNT - 1;
		int m;

		int ans = -1;

		while (s <= e) {
			m = (s + e) / 2;

			if (prime[m] <= x) {
				ans = m;
				s = m + 1;
			} else {
				e = m - 1;
			}
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		init();

		int a, b;
		int l, r;

		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			l = getLeft(a);
			r = getRight(b);

			if ((r - l + 1) % 2 == 0) {
				sb.append("-1\n");
			} else {
				sb.append(prime[(l + r) / 2]).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}