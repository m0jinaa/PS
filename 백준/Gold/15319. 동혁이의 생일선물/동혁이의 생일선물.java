import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;

	static long pow(long x, int t) {
		if (t == 0)
			return 1;
		else if (t % 2 != 0) {
			return (pow(x, t - 1) * x) % MOD;
		} else {
			long nx = pow(x, t / 2);

			return (nx * nx) % MOD;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long x;
		int t, ind;

		long answer = 0;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Long.parseLong(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			ind = 0;

			while (t > 0) {
				if (t % 2 != 0) {
					answer = (answer + pow(x, ind)) % MOD;
				}
				ind++;
				t >>= 1;
			}
		}

		System.out.println(answer);
	}
}