import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, h;
	static double[][] dp;
	static int[] grade = new int[] { 40, 37, 33, 30, 27, 23, 20, 17, 13, 10, 0};
	static int[][] subjects;

	static double getMax() {

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 11; j++) {
				for(int k = subjects[i][j];k<=h;k++) {
					dp[i][k] = Math.max(dp[i][k], dp[i-1][k-subjects[i][j]]+grade[j]);
				}
			}
		}

		double max = 0;

		for (int i = 0; i <= h; i++) {
			max = Math.max(max, dp[n][i] /10.0/ n);
		}

		return max;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		double answer;
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			subjects = new int[n + 1][11];
			dp = new double[n + 1][h + 1];

			int x;

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < 10; j++) {
					x = Integer.parseInt(st.nextToken());

					subjects[i][j] = x;
				}
			}

			answer = getMax();

			sb.append(String.format("Data Set %d:\n%.2f\n", t,answer));
		}
		
		System.out.print(sb.toString());
	}
}