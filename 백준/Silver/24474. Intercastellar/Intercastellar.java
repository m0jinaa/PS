import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static long[] value;
	static long[] sum;

	static int getLength(int start, long x) {
		int s = start;
		int e = n;

		int m;
		int ret = -1;

		while (s <= e) {
			m = (s + e) / 2;

			if (sum[m] >= x) {
				ret = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		value = new long[n + 1];
		sum = new long[n + 1];

		long a;
		long c = 1L;

		for (int i = 1; i <= n; i++) {
			a = Long.parseLong(br.readLine());
			c = 1L;

			while (a % 2 == 0) {
				c *= 2;
				a /= 2;
			}

			value[i] = a;
			sum[i] = sum[i - 1] + c;

		}

		int s = 1;

		int q = Integer.parseInt(br.readLine());

		while (q-- > 0) {
			a = Long.parseLong(br.readLine());

			s = getLength(s, a);

			sb.append(value[s]).append("\n");
		}

		System.out.print(sb.toString());
	}
}