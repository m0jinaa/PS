import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static char[] S;
	static int[][] dp;

	static int getMin(int x, int c) { // x 위치부터 볼거고 현재까지 c번 일격을 가했을 때 남는 최소 문자 수
		if (x == n)
			return 0;
		if (dp[x][c] != -1)
			return dp[x][c];

		int cnt = n - x + 1;

		cnt = Math.min(cnt, getMin(x + 1, c) + 1);

		if (c < k && S[x] != 'X') {
			for (int nx = x + 1; nx < n; nx++) {
				if (S[x] != S[nx])
					continue;
				cnt = Math.min(cnt, getMin(nx + 1, c + 1));
			}
		}

		return dp[x][c] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new int[n][k + 1];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		S = br.readLine().toCharArray();

		int answer = getMin(0, 0);

		System.out.println(answer);
	}
}