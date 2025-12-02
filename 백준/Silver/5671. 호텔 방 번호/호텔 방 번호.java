import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String input;

		int n, m, x, d, answer;
		boolean[] digit = new boolean[10];
		boolean possible;

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			st = new StringTokenizer(input, " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			answer = 0;

			for (int i = n; i <= m; i++) {
				Arrays.fill(digit, false);
				possible = true;
				x = i;

				while (x > 0) {
					d = x % 10;
					x /= 10;

					if (digit[d]) {
						possible = false;
						break;
					}
					digit[d] = true;
				}

				if (possible)
					answer++;
			}

			sb.append(answer).append("\n");
		}
		System.out.print(sb.toString());
	}
}