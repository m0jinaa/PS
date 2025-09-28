import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;

	static long pow(int x, long p) {
		if (p == 0)
			return 1;
		else if (p == 1)
			return x;
		else if (p % 2 != 0) {
			return (pow(x, p - 1) * x) % MOD;
		} else {
			long y = pow(x, p / 2);

			return (y * y) % MOD;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		long n = Long.parseLong(st.nextToken());

		long answer = 1;
		long now;
		long c;
		int[] dividors = new int[10];
		int ind = 0;

		if (x % 2 == 0) {
			dividors[ind++] = 2;
			while (x % 2 == 0)
				x /= 2;
		}

		for (int i = 3; i * i <= x; i += 2) {
			if (x % i != 0)
				continue;

			dividors[ind++] = i;

			while (x % i == 0) {
				x /= i;
			}
		}

		if (x != 1) {
			dividors[ind++] = x;
		}

		for (int d : dividors) {
			if (d == 0)
				break;

			c = 0;
			now = n;

			while (now > 0) {
				now /= d;
				c += now;
			}

			answer = (answer * pow(d, c)) % MOD;
		}
		System.out.println(answer);
	}
}