import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long n;
		String input;
		long x;

		while ((input = br.readLine()) != null && !input.isEmpty()) {

			n = Long.parseLong(input);
			x = 1;
			while (true) {
				x *= 9;

				if (x >= n) {
					sb.append("Baekjoon wins.\n");
					break;
				}

				x *= 2;

				if (x >= n) {
					sb.append("Donghyuk wins.\n");
					break;
				}
			}
		}

		System.out.println(sb.toString());
	}
}