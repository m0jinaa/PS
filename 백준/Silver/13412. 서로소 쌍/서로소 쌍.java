import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int gcd(int a, int b) {
		int t;

		while (b != 0) {
			t = a % b;
			a = b;
			b = t;
		}

		return a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		int n, answer;

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			answer = 1;

			for (int i = 2; i <= n / i; i++) {
				if (n % i != 0 || gcd(i, n / i) != 1)
					continue;
				answer++;
			}

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}