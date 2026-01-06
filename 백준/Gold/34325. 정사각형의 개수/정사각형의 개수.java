import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MOD = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long[] add = new long[] { 0, 0 };

		long answer = 0;

		for (int i = 1; i <= n; i++) {
			add[i % 2] += (Math.max(0, i - 2) * 4);

			answer = ((answer + (1L * i * i) % MOD + add[i % 2]) * k) % MOD;
		}

		System.out.println(answer);
	}
}