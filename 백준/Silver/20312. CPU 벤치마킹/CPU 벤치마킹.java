import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		final int MOD = 1_000_000_007;

		long answer = 0;
		long bef = 0;

		st = new StringTokenizer(br.readLine(), " ");

		long x;

		while (st.hasMoreTokens()) {
			x = Long.parseLong(st.nextToken());
			bef = ((bef + 1) * x) % MOD;
			answer = (answer + bef) % MOD;
		}

		System.out.println(answer);
	}
}