import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] A, B;
	static int n, m;
	static int[][] dp;
	static final int INF = 1_000_000_007;

	static int getMin(int x, int y) {
		if (x == n && y == m)
			return dp[x][y] = 0;
		else if (dp[x][y] != -1)
			return dp[x][y];
		else if (x == n) {
			return dp[x][y] = m - y;
		} else if (y == m)
			return dp[x][y] = n - x;

		int cnt = INF;

		if (A[x] == B[y])
			cnt = Math.min(cnt, getMin(x + 1, y + 1));
		else {
			// 문자 삽입
			cnt = Math.min(cnt, 1 + getMin(x + 1, y));

			// 문자 삭제
			cnt = Math.min(cnt, 1 + getMin(x, y + 1));

			// 문자 교체
			cnt = Math.min(cnt, 1 + getMin(x + 1, y + 1));
		}
		return dp[x][y] = cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		A = br.readLine().toCharArray();
		n = A.length;

		B = br.readLine().toCharArray();
		m = B.length;

		dp = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}

		int answer = getMin(0, 0);

		System.out.println(answer);
	}
}