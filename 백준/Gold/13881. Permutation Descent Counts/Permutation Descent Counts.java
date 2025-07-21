import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 100;
	static final int MOD = 1_001_113;
	static int[][] dp;

	static int getCnt(int x, int d) {
		if (dp[x][d] != 0)
			return dp[x][d];
		else if (d == 0 || d == x - 1)
			return dp[x][d] = 1;

		int c = ((d + 1) * getCnt(x - 1, d) + (x - d) * getCnt(x - 1, d - 1)) % MOD;

		return dp[x][d] = c;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		dp = new int[MAX + 1][MAX];

		int tc = Integer.parseInt(br.readLine());

		int v, n, k;
		for (int t = 1; t <= tc; t++) {

			st = new StringTokenizer(br.readLine(), " ");

			k = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			sb.append(k).append(" ").append(getCnt(n, v)).append("\n");
		}

		System.out.println(sb.toString());
	}
}