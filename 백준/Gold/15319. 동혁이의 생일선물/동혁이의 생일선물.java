import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MOD = 1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		long x;
		int t;
		long v;

		long answer = 0;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Long.parseLong(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			v = 1;

			while (t > 0) {
				if (t % 2 != 0) {
					answer = (answer + v) % MOD;
				}

				v = (v * x) % MOD;
				t >>= 1;
			}
		}

		System.out.println(answer);
	}
}