import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long m, k;

	static long[] A;

	static boolean check(long x) {

		int s = 0;
		int e = 0;
		long sum = 0;

		long cnt = 0;

		while (e < n) {
			sum += (A[e] + x);

			while (sum >= m) {
				cnt += (n - e);
				sum -= (A[s++] + x);
			}
			e++;
		}

		return cnt >= k;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());

		A = new long[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		long s = 0;
		long e = m;

		long answer = 0;

		long mid;

		while (s <= e) {
			mid = (s + e) / 2;

			if (check(mid)) {
				answer = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}

		System.out.println(answer);
	}
}