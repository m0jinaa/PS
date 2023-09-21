import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int total = 0;

		st = new StringTokenizer(br.readLine(), " ");

		int first = Integer.parseInt(st.nextToken());

		total += first;
		for (int i = 1; i < n; i++) {
			total += Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int MAX = c + 1;
		double[][] dp = new double[MAX][c + 1];
		dp[0][0] = 1;

		int week;

		for (int i = 0; i < MAX; i++) {
			for (int j = 1; j <= c; j++) {
				week = total + (j - 1) * x;
				if (i > 0) {
					dp[i][j] += dp[i - 1][j - 1] * (first + (i - 1) * x) * 1.0 / week;
				}
				dp[i][j] += dp[i][j - 1] * (week - (first + i * x)) * 1.0 / week;
			}
		}
		double answer = 0;

		for (int i = 0; i < MAX; i++) {
			answer += (first + i * x) * dp[i][c];
		}

		System.out.println(answer);
	}
}