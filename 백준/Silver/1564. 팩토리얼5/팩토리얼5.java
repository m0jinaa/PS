import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long answer = 1L;

		for (int i = n; i > 0; i--) {
			answer *= i;

			while (answer % 10 == 0) {
				answer /= 10;
			}

			answer %= 1000000000000L;
		}

		System.out.printf("%05d", answer % 100000);
	}
}