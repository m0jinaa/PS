import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, s, m;
	static int[][] dp;

	static long getCnt() {
		dp[0][0] = 1;

		int v;
		for (int i = 1; i <= m; i++) {
			v = i * i;
			for (int j = n; j > 0; j--) {
				for (int k = s - 1; k >= v; k--) {
					dp[j][k] += dp[j - 1][k - v];
				}
			}
		}

		long answer = 0;

		for (int i = 0; i < s; i++) {
			answer += dp[n][i];
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		m = (int) Math.sqrt(s);

		dp = new int[n + 1][s];

		long cnt = getCnt();

		System.out.println(cnt);
	}
}