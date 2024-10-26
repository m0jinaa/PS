import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long k;
	static long[] A;

	static boolean check(long x) {

		long p;

		long sum = 0;

		for (long a : A) {
			p = Math.min(a, x);

			sum += (p * x - p * (p - 1) / 2);
		}

		return sum >= k;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Long.parseLong(st.nextToken());

		A = new long[n];

		st = new StringTokenizer(br.readLine(), " ");

		int bef = Integer.parseInt(st.nextToken());
		int now;
		for (int i = 1; i < n; i++) {
			now = Integer.parseInt(st.nextToken());
			A[i - 1] = now - bef;
			bef = now;
		}

		A[n - 1] = 1_999_999_999;

		long s = 1;
		long e = 1_500_000_000;

		long answer = e + 1;
		long m;

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