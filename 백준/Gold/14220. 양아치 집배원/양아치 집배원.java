import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] dp;
	static int[][] dist;
	static final int INF = 1_000_000_007;

	static int getShortest(int x, int c) {
		if (dp[x][c] != -2)
			return dp[x][c];
		else if (c == n)
			return dp[x][c] = 0;

		int d = INF;
		int temp;
		for (int i = 0; i < n; i++) {
			if (dist[x][i] == 0 || x == i)
				continue;
			temp = getShortest(i, c + 1);
			if (temp == -1)
				continue;
			d = Math.min(d, dist[x][i] + temp);
		}

		return dp[x][c] = (d == INF) ? -1 : d;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		dist = new int[n][n];
		dp = new int[n][n + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], -2);
		}

		int answer = INF;
		int temp;
		for (int i = 0; i < n; i++) {
			temp = getShortest(i, 1);

			if (temp == -1)
				continue;

			answer = Math.min(answer, temp);
		}

		System.out.println(answer == INF ? -1 : answer);
	}
}