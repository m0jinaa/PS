import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long getLevel(long exp) {
		long s = 1;
		long e = 1_000_000_000;

		long m;

		long need;

		long ret = 1;

		while (s <= e) {
			m = (s + e) / 2;
			need = m * m - m;
			if (need <= exp) {
				ret = m;
				s = m + 1;
			} else {
				e = m - 1;
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		long n;

		long exp;

		while (t-- > 0) {
			n = Long.parseLong(br.readLine());

			exp = n * (1 + n) / 2;

			sb.append(getLevel(exp)).append("\n");
		}

		System.out.print(sb.toString());
	}
}