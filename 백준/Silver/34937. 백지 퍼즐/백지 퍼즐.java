import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;

	static long pow(int x) {
		if (x == 0) {
			return 1L;
		} else if (x == 1) {
			return 3;
		} else {
			long p = pow(x / 2);

			if (x % 2 == 0) {
				return (p * p) % MOD;
			} else {
				return (((p * p) % MOD) * 3) % MOD;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int x = (n - 1) * m + (m - 1) * n;
		
		long answer = pow(x);
		
		System.out.println(answer);
	}
}