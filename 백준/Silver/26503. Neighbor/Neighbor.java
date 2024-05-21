import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		long a, b, c, d;
		long x, y;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			c = Long.parseLong(st.nextToken());
			d = Long.parseLong(st.nextToken());

			x = Math.abs(a * d - c * b);
			y = b * d;

			if (gcd(x, y) == x) {
				sb.append(1).append("/").append(y / x).append("\n");
			} else {
				sb.append("NOT NEIGHBORS\n");
			}
		}

		System.out.print(sb.toString());
	}
}