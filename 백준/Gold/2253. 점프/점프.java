import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, limit;
	static boolean[] small;
	static int[][] dp;
	static final int INF = 1_000_000_007;
	static int MAX;

	static int getMin(int x, int c) {
		if (dp[x][c] != INF)
			return dp[x][c];
		if (x == n)
			return dp[x][c] = 0;
		int ret = MAX;
		// c-1칸 점프
		if (c > 1 && x + c - 1 <= n && !small[x + c - 1]) {
			ret = Math.min(ret, getMin(x + c - 1, c - 1) + 1);
		}

		// c칸 점프
		if (c > 0 && x + c <= n && !small[x + c]) {
			ret = Math.min(ret, getMin(x + c, c) + 1);
		}

		// c+1칸 점프
		if (c < limit && x + c + 1 <= n && !small[x + c + 1]) {
			ret = Math.min(ret, getMin(x + c + 1, c + 1) + 1);
		}

		return dp[x][c] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		limit = (int) Math.sqrt(2 * n) + 1;
		int x;
		MAX = n + 1;
		small = new boolean[n + 1];
		dp = new int[n + 1][limit + 1];

		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], INF);
		}
		while (m-- > 0) {
			x = Integer.parseInt(br.readLine());
			small[x] = true;
		}

		int answer = getMin(1, 0);

		System.out.println(answer == MAX ? -1 : answer);
	}
}