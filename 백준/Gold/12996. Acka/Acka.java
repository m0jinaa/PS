import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[][][][] dp;
	static final int MOD = 1_000_000_007;
	static int[] da = new int[] { -1, 0, 0, -1, -1, 0, -1 };
	static int[] db = new int[] { 0, -1, 0, -1, 0, -1, -1 };
	static int[] dc = new int[] { 0, 0, -1, 0, -1, -1, -1 };

	static boolean inRange(int a, int b, int c) {
		if (a < 0 || b < 0 || c < 0)
			return false;
		return true;
	}

	static long getCnt(int s, int a, int b, int c) {
		if (dp[s][a][b][c] != -1)
			return dp[s][a][b][c];
		else if (s == 0) {
			if (a + b + c == 0) {
				return dp[s][a][b][c] = 1;
			} else {
				return dp[s][a][b][c] = 0;
			}
		}
		long cnt = 0;
		int na, nb, nc;
		for (int i = 0; i < 7; i++) {
			na = a + da[i];
			nb = b + db[i];
			nc = c + dc[i];
			if (!inRange(na, nb, nc))
				continue;
			cnt = (cnt + getCnt(s - 1, na, nb, nc)) % MOD;

		}

		return dp[s][a][b][c] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int s = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		dp = new long[s + 1][a + 1][b + 1][c + 1];

		for (int i = 0; i <= s; i++) {
			for (int j = 0; j <= a; j++) {
				for (int k = 0; k <= b; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}

		long answer = getCnt(s, a, b, c);

		System.out.println(answer);
	}
}