import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;
	static long[][] dp; // [정점][횟수]
	static ArrayList<Integer>[] canGo;

	static long getCnt(int x, int c) {
		if (dp[x][c] != -1)
			return dp[x][c];
		else if (c == 0)
			return dp[x][c] = 1;
		long cnt = 0;

		for (int y : canGo[x]) {
			cnt += getCnt(y, c - 1);
			cnt %= MOD;
		}

		return dp[x][c] = cnt;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		canGo = new ArrayList[n + 1];
		dp = new long[n + 1][8];
		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
			Arrays.fill(dp[i], -1);
		}

		int s, e;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			canGo[s].add(e);
			canGo[e].add(s);
		}

		long answer = 0;

		for (int i = 1; i <= n; i++) {
			answer += getCnt(i, 7);
			answer %= MOD;
		}

		System.out.println(answer);
	}
}