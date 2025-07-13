import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long gcd(long x, long y) {
		long t;

		while (y != 0) {
			t = x % y;
			x = y;
			y = t;
		}

		return x;
	}

	static long lcm(long x, long y) {
		return x * y / gcd(x, y);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		long n;

		long answer;

		while (t-- > 0) {
			n = Long.parseLong(br.readLine());

			answer = Math.max(lcm(n, lcm(n - 1, n - 2)),
					Math.max(lcm(n, lcm(n - 1, n - 3)), lcm(n - 1, lcm(n - 2, n - 3))));

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}