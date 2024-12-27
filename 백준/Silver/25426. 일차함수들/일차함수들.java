import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class F implements Comparable<F> {
		long a, b;

		public F(long a, long b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(F f) {
			if (this.a != f.a) {
				return this.a > f.a ? 1 : -1;
			} else if (this.b != f.b) {
				return this.b > f.b ? 1 : -1;
			} else {
				return 0;
			}
		}

		public long fx(int x) {
			return a * x + b;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		F[] fs = new F[n];

		long a, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());

			fs[i] = new F(a, b);
		}

		Arrays.sort(fs);

		long answer = 0;

		for (int i = 0; i < n; i++) {
			answer += fs[i].fx(i + 1);
		}

		System.out.println(answer);
	}
}