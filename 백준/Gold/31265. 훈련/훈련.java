import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[][] dp;
	static int[][] training;

	public static int getMax() {
		int answer = -1;

		for (int i = 1; i <= n; i++) {
			for (int x : training[i]) {
				for (int j = m; j >= x; j--) {
					dp[i][j] = dp[i][j] || dp[i - 1][j - x] || dp[i][j - x];
				}
			}
		}

		for (int i = m; i >= 0; i--) {
			if (dp[n][i]) {
				answer = i;
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dp = new boolean[n + 1][m + 1];

		dp[0][0] = true;

		st = new StringTokenizer(br.readLine(), " ");
		int d;

		training = new int[n + 1][];
		int[] cnt = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			d = Integer.parseInt(st.nextToken());
			training[i] = new int[d];
			cnt[i] = d;
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < cnt[i]; j++) {
				training[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = getMax();

		System.out.println(answer);
	}
}