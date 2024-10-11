import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long getGCD(long x, long y) {
		long t;
		while (y != 0) {
			t = x % y;
			x = y;
			y = t;
		}

		return x;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int d = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long lcm = 1L;

		st = new StringTokenizer(br.readLine(), " ");

		long x;

		while (d-- > 0) {
			x = Long.parseLong(st.nextToken());

			lcm = lcm * x / getGCD(lcm, x);
		}

		st = new StringTokenizer(br.readLine(), " ");

		long gcd = Long.parseLong(st.nextToken());

		while (--m > 0) {
			x = Long.parseLong(st.nextToken());

			gcd = getGCD(gcd, x);
		}

		int limit = (int) Math.sqrt(gcd);

		int answer = 0;

		for (int i = 1; i <= limit; i++) {
			if (gcd % i != 0)
				continue;

			if (i % lcm == 0) {
				answer++;
			}

			if ((gcd / i != i) && (gcd / i) % lcm == 0)
				answer++;
		}

		System.out.println(answer);
	}
}