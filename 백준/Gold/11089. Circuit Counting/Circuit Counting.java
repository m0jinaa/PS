import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[][][] dp;
	static int[][] vectors;
	static int n;
	static final int MAX = 801;

	static boolean inRange(int x) {
		if (x < 0 || x >= MAX)
			return false;
		return true;
	}

	static long fill() {
		dp[1][MAX / 2][MAX / 2] = 1;

		int ind = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < MAX; j++) {
				if (!inRange(j - vectors[i][0])) {
					System.arraycopy(dp[1 - ind][j], 0, dp[ind][j], 0, MAX);
					continue;
				}
				for (int k = 0; k < MAX; k++) {
					dp[ind][j][k] = dp[1 - ind][j][k];
					if (!inRange(k - vectors[i][1])) {
						continue;
					}

					dp[ind][j][k] += dp[1 - ind][j - vectors[i][0]][k - vectors[i][1]];
				}
			}
			ind = 1 - ind;
		}

		return dp[1 - ind][MAX / 2][MAX / 2] - 1;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		vectors = new int[n][2];

		int x, y;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
            
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			vectors[i][0] = x;
			vectors[i][1] = y;
		}

		dp = new long[2][MAX][MAX];

		long answer = fill();

		System.out.println(answer);

	}
}