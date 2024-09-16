import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long gcd(long a, long b) {
		long t;

		while (b != 0) {
			t = a % b;
			a = b;
			b = t;
		}

		return a;
	}

	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long x = 0, y = 1;

		int n = Integer.parseInt(br.readLine());

		long a, b, g;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());

			g = gcd(a, b);

			a /= g;
			b /= g;

			x = gcd(x, a);
			y = lcm(y, b);
		}

		sb.append(x).append(" ").append(y);

		System.out.println(sb.toString());
	}
}