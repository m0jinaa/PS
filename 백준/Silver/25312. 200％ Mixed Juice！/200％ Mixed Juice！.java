import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Drink implements Comparable<Drink> {
		long w, v;

		public Drink(long w, long v) {
			super();
			this.w = w;
			this.v = v;
		}

		@Override
		public int compareTo(Drink d) {
			long a = this.w * d.v;
			long b = this.v * d.w;

			if (a < b)
				return -1;
			else if (a > b)
				return 1;
			else
				return 0;
		}
	}

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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		Drink[] drinks = new Drink[n];

		long w, v;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			w = Long.parseLong(st.nextToken());
			v = Long.parseLong(st.nextToken());

			drinks[i] = new Drink(w, v);
		}

		long sugarA = 0;
		long sugarB = 1;

		long sum = 0;
		long x, y;
		long gcd;

		Arrays.sort(drinks);

		for (Drink d : drinks) {
			if (sum == m)
				break;
			else if (sum + d.w <= m) {
				sugarA += d.v;
				sum += d.w;
			} else {
				x = d.v * (m - sum);
				y = d.w;

				gcd = getGCD(x, y);
				x /= gcd;
				y /= gcd;

				sugarA = sugarA * y + x;
				sugarB = y;

				break;
			}
		}

		sb.append(sugarA).append("/").append(sugarB).append("\n");

		System.out.print(sb.toString());
	}
}