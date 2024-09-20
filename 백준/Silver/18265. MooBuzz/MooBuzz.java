import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		long s = 1;
		long e = 1_000_000_000_000L;

		long answer = e + 1;

		long m;
		long c;

		while (s <= e) {
			m = (s + e) / 2;
			c = m - m / 3 - m / 5 + m / 15;

			if (c < n) {
				s = m + 1;
			} else {
				answer = m;
				e = m - 1;
			}
		}

		System.out.println(answer);
	}
}