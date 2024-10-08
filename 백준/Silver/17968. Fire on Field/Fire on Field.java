import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;

	static boolean check(int x, int v) {
		for (int i = 1; i <= x / 2; i++) {
			if (v == 2 * dp[x - i] - dp[x - 2 * i])
				return false;
		}

		dp[x] = v;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		dp = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			for (int v = 1;; v++) {
				if (check(i, v))
					break;
			}
		}

		System.out.println(dp[n]);
	}
}