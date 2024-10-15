import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;

	static long pow(int a, long b) {
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a % MOD;
		}

		long p;

		p = pow(a, b / 2);

		if (b % 2 == 0) {
			return (p * p) % MOD;
		} else {
			return (((p * p) % MOD) * a) % MOD;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		long answer;

		if (a == 1) {
			answer = b % MOD;
		} else {
			answer = (((pow(a, b) - 1 + MOD) % MOD) * pow(a - 1, MOD - 2)) % MOD;
		}

		System.out.println(answer);
	}
}