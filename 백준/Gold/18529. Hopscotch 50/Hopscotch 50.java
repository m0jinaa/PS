import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[][] map;
	static int[][] dp;
	static final int INF = 1_000_000_007;;

	static int getShortest(int x, int y) {
		if (dp[x][y] != -2)
			return dp[x][y];
		else if (map[x][y] == k)
			return dp[x][y] = 0;

		int dist = INF;
		int temp;
		int d;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != map[x][y] + 1)
					continue;
				d = Math.abs(i - x) + Math.abs(j - y);

				temp = getShortest(i, j);
				if (temp == -1)
					continue;
				dist = Math.min(dist, temp + d);
			}
		}

		return dp[x][y] = (dist == INF) ? -1 : dist;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -2;
			}
		}

		int answer = INF;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 1)
					continue;
				answer = Math.min(answer, getShortest(i, j));
			}
		}

		System.out.println(answer);
	}
}