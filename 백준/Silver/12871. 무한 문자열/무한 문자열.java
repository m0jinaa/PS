import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int gcd(int a, int b) {
		int t;
		if (a < b) {
			t = a;
			a = b;
			b = t;
		}

		while (b != 0) {
			t = a % b;
			a = b;
			b = t;
		}

		return a + b;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] S = br.readLine().toCharArray();
		char[] T = br.readLine().toCharArray();

		int n = S.length;
		int m = T.length;

		int t = n * m / gcd(n, m);

		int i = 0;

		int answer = 1;

		while (i < t) {
			if (S[i % n] != T[i % m]) {
				answer = 0;
				break;
			}

			i++;
		}

		System.out.println(answer);
	}
}