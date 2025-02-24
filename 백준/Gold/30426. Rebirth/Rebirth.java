import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[][] dp = new boolean[k + 1][n];

		boolean[] unstable = new boolean[n];

		int[][] move = new int[k][2];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			move[i][0] = Integer.parseInt(st.nextToken());
			move[i][1] = Integer.parseInt(st.nextToken());
		}

		int l = Integer.parseInt(br.readLine());
		int loc;

		for (int i = 0; i < l; i++) {
			loc = Integer.parseInt(br.readLine());
			unstable[loc] = true;
		}

		dp[0][m] = true;

		int nj;

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				if (unstable[j] || !dp[i][j])
					continue;
				for (int s = 0; s < 2; s++) {
					nj = (j + move[i][s]) % n;

					dp[i + 1][nj] = true;
				}
			}
		}

		System.out.println(dp[k][0] ? "utopia" : "dystopia");
	}
}