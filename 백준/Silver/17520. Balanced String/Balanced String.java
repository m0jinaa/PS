import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		final int MOD = 16769023;

		int k = (n + 1) / 2;

		int answer = 1;

		while (k-- > 0) {
			answer = (answer << 1) % MOD;
		}

		System.out.println(answer);
	}
}