import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int l, t;
	static int[][] teachers;
	static int[] dp;
	static final int INF = 1_000_000_007;

	static int getMin() {

		Arrays.fill(dp, INF);

		dp[0] = 0;

		for (int[] teacher : teachers) {
			for (int i = l; i > 0; i--) {
				for (int j = 1; j < 4 && i - j >= 0; j++) {
					dp[i] = Math.min(dp[i], dp[i-j]+teacher[j]);
				}
			}
		}

		return dp[l];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		l = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		teachers = new int[t][4];
		dp = new int[l + 1];

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < 4; j++) {
				teachers[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = getMin();

		System.out.println(answer);
	}
}