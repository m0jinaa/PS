import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		double answer;

		answer = n;
		for (long x = 2; x * x <= n; x++) {
			if (n % x == 0) {
				answer -= (answer / x);
				while (n % x == 0) {
					n /= x;
				}
			}
		}

		if (n > 1) {
			answer -= answer / n;
		}

		System.out.println((long) answer);
	}
}