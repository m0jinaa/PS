import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][][] dp;
	static int n;
	static int[] pasta;
	static final int MOD = 10000;

	static int getCnt(int x, int a, int b) {
		if (x > n)
			return 1;
		else if (dp[x][a][b] != -1)
			return dp[x][a][b];

		int cnt = 0;
		if (pasta[x] != 0) {
			if (a == b && b == pasta[x])
				cnt = 0;
			else
				cnt = getCnt(x + 1, b, pasta[x]);
		} else {
			for (int i = 1; i <= 3; i++) {
				if (a == b && b == i)
					continue;
				cnt = (cnt + getCnt(x + 1, b, i)) % MOD;
			}
		}

		return dp[x][a][b] = cnt;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		dp = new int[n + 1][4][4];
		pasta = new int[n + 1];

		int a, b;

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < 4; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			pasta[a] = b;
		}

		int answer = getCnt(1, 0, 0);

		System.out.println(answer);
	}
}