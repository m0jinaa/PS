import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		final int MOD = 1_000_000_007;

		long sum = 0;

		long x = 0;

		st = new StringTokenizer(br.readLine(), " ");

		long answer = 0;

		while (n-- > 0) {
			x = Long.parseLong(st.nextToken());

			answer = (answer + x * sum) % MOD;

			sum = (sum + x) % MOD;
		}

		System.out.println(answer);
	}
}