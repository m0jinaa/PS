import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long k;
	static long[] A;

	static boolean check(long x) {
		long sum = 0L;

		for (long a : A) {
			sum += Math.max(0L, a - x);
		}
		return sum <= k;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		A = new long[n];

		for (int i = 0; i < n; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		long s = 0;
		long e = 1_000_000_000_000L;

		long m;

		long answer = e + 1;

		while (s <= e) {
			m = (s + e) / 2;

			if (check(m)) {
				answer = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		System.out.println(answer);
	}
}