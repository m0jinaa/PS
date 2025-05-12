import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[] day;

	static boolean isPossible(int d) {

		long c = 0;

		for (int i = 0; i < n && c <= d; i++) {
			c += Math.max(0, day[i] - d);
		}

		return c <= d;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		day = new long[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			day[i] = Long.parseLong(st.nextToken());
		}

		int b;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			b = Integer.parseInt(st.nextToken());
			day[i] = (long) Math.ceil(day[i] * 1.0 / b);
		}

		int answer = 0;

		int s = 0;
		int e = 1_000_000_000;

		int m;

		while (s <= e) {
			m = (s + e) / 2;

			if (isPossible(m)) {
				answer = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		System.out.println(answer);
	}
}