import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int a, k, max, high;
	static int[] score;
	static boolean[][] dp;

	static int getCnt() {
		dp[1][0] = dp[0][0] = true;

		int ind = 0;
		for (int i = 0; i < k; i++) {
			for (int s : score) {
				for (int j = high; j >= s; j--) {
					dp[ind][j] |= dp[1 - ind][j];

					// normal
					dp[ind][j] |= dp[1 - ind][j - s];
					// double
					if (j >= s * 2)
						dp[ind][j] |= dp[1 - ind][j - 2 * s];
					// triple
					if (s != max && j >= s * 3)
						dp[ind][j] |= dp[1 - ind][j - 3 * s];
				}
			}
			ind = 1 - ind;
		}

		int cnt = 0;

		for (int i = 0; i <= high; i++) {
			if (dp[1 - ind][i]) {
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			if (t != 1)
				sb.append("\n");

			max = 0;
			high = 0;

			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			score = new int[a];

			for (int i = 0; i < a; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, score[i]);
			}

			high = max * 3 * k;

			dp = new boolean[2][high + 1];

			sb.append("Scenario #").append(t).append(":\n").append(getCnt()).append("\n");
		}
		System.out.println(sb.toString());
	}
}