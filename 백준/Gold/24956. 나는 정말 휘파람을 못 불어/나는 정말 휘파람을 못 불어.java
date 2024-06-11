import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[] row = br.readLine().toCharArray();

		long w = 0;
		long h = 0;
		long e1 = 0;
		long e2 = 0;

		final int MOD = 1_000_000_007;

		for (char c : row) {
			switch (c) {
			case 'W':
				w = (w + 1) % MOD;
				break;
			case 'H':
				h = (h + w) % MOD;
				break;
			case 'E':
				e2 = (e2 + e2 + e1) % MOD;
				e1 = (e1 + h) % MOD;
				break;
			}
		}

		System.out.println(e2);
	}
}