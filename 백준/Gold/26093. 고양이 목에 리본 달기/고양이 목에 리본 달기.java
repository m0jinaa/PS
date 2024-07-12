import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] like = new int[n + 1][k];
		int[][] dp = new int[n + 1][k];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < k; j++) {
				like[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int first = 0;
		int second = 0;
		int firstInd = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < k; j++) {
				if (j == firstInd) {
					dp[i][j] = second + like[i][j];
				} else {
					dp[i][j] = first + like[i][j];
				}
			}

			first = 0;
			second = 0;

			for (int j = 0; j < k; j++) {
				if (first < dp[i][j]) {
					second = first;
					first = dp[i][j];
					firstInd = j;
				} else if (second < dp[i][j]) {
					second = dp[i][j];
				}
			}
		}

		int answer = first;

		System.out.println(answer);
	}
}