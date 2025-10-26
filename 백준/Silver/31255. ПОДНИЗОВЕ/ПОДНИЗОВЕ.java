import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MOD = 123_456_789;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int left = p;
		int mid = q - p;
		int right = n - q + 1;

		long answer = 0;

		answer = ((1L * left * mid) % MOD + (1L * mid * right) % MOD + (1L * left * right) % MOD) % MOD;

		System.out.println(answer);
	}
}