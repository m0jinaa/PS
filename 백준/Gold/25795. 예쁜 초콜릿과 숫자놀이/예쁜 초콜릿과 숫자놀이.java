import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long answer = 0;
	static final int MOD = 100_000;
	static int n, a, b;
	static long c;
	static boolean[][][] dp;

	static void getMaxChocolate(int x, int y, int z) {
		if (x == n && y == n) {
			answer = Math.max(answer, z);
			return;
		} else if (dp[x][y][z])
			return;

		dp[x][y][z] = true;

		if (x < n) {
			getMaxChocolate(x + 1, y, (z + b) % MOD);
		}

		if (x > y) {
			getMaxChocolate(x, y + 1, (int) ((c * z) % MOD));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Long.parseLong(st.nextToken());

		dp = new boolean[n + 1][n + 1][MOD];

		getMaxChocolate(0, 0, a);

		System.out.println(answer);
	}
}