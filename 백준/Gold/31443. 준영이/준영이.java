import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;

	static long pow(int x, int p) {
		if (p == 0)
			return 1;
		else if (p == 1)
			return x;

		if (p % 2 != 0) {
			return (pow(x, p - 1) * x) % MOD;
		} else {
			long pp = pow(x, p / 2);

			return (pp * pp) % MOD;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long answer = 1L;

		int size = n * m;

		if (size <= 4) {
			answer = size;
		} else {
			int three = size / 3;
			int two = 0;

			if (size % 3 == 1) {
				three--;
				two = 2;
			} else if (size % 3 == 2) {
				two = 1;
			}

			answer = (pow(3, three) * pow(2, two)) % MOD;
		}

		System.out.println(answer);
	}
}