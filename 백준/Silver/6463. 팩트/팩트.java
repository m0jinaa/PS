import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input;
		int n;
		long answer;

		while ((input = br.readLine()) != null && !input.isEmpty()) {

			n = Integer.parseInt(input);

			answer = 1;

			for (int i = 2; i <= n; i++) {
				answer *= i;

				while (answer % 10 == 0)
					answer /= 10;

				answer %= 100000;
			}

			sb.append(String.format("%5d -> %d\n", n, answer % 10));
		}

		System.out.print(sb.toString());
	}
}