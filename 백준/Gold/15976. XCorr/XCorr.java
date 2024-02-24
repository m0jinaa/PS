import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int m;
	static int[] B;

	static int findLeft(int x) {
		int ind = m + 1;

		int s = 0;
		int e = m - 1;
		int mid;

		while (s <= e) {
			mid = (s + e) / 2;
			if (x <= B[mid]) {
				ind = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		return ind;
	}

	static int findRight(int x) {
		int ind = -1;

		int s = 0;
		int e = m - 1;
		int mid;

		while (s <= e) {
			mid = (s + e) / 2;
			if (B[mid] <= x) {
				ind = mid;
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return ind;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] A = new int[n];
		long[] Avalue = new long[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A[i] = Integer.parseInt(st.nextToken());
			Avalue[i] = Long.parseLong(st.nextToken());
		}

		m = Integer.parseInt(br.readLine());

		B = new int[m];
		long[] Bsum = new long[m];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			B[i] = Integer.parseInt(st.nextToken());
			Bsum[i] = (i == 0 ? 0 : Bsum[i - 1]) + Long.parseLong(st.nextToken());
		}

		long answer = 0;

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		int l, r;
		int x;
		long xcorr;

		for (int i = 0; i < n; i++) {
			x = A[i];
			l = findLeft(x + a);
			r = findRight(x + b);

			if (l > r)
				continue;

			xcorr = (Bsum[r] - (l == 0 ? 0 : Bsum[l - 1])) * Avalue[i];

			answer += xcorr;
		}

		System.out.println(answer);
	}
}