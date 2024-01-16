import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m; // n : x의 길이, m : y의 길이
	static char[] X, Y;
	static int[][] dp;
	static int a, b, c;
	static final int INF = -1_000_000_007;

	static int getMax(int i, int j) {
		if (dp[i][j] != INF)
			return dp[i][j];

		int max = INF;

		if (i < n && j < m) {
			// 공백 아닐 때 일치 불일치 확인
			if (X[i] == Y[j]) {
				max = Math.max(max, a + getMax(i + 1, j + 1));
			} else {
				max = Math.max(max, c + getMax(i + 1, j + 1));
			}

			// X 공백 넣기
			max = Math.max(max, b + getMax(i, j + 1));

			// Y 공백 넣기
			max = Math.max(max, b + getMax(i + 1, j));

		} else if (i < n) {
			max = Math.max(max, (n - i) * b);
		} else {
			max = Math.max(max, (m - j) * b);
		}

		return dp[i][j] = max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		X = br.readLine().toCharArray();
		Y = br.readLine().toCharArray();

		n = X.length;
		m = Y.length;

		dp = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], INF);
		}

		dp[n][m] = 0;

		int answer = getMax(0, 0);

		System.out.println(answer);
	}
}