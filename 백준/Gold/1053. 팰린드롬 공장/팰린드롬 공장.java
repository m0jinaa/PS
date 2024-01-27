import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] word;
	static int n;
	static int[][][][] dp;
	static final int INF = 1_000_000_007;

	static void swap(int i, int j) {
		char c = word[i];
		word[i] = word[j];
		word[j] = c;
	}

	static int getMin(int s, int e, int a, int b) {
		if (s >= e) {
			return dp[s][e][a][b] = 0;
		} else if (dp[s][e][a][b] != INF)
			return dp[s][e][a][b];

		int cnt = INF;

		if (word[s] == word[e]) {
			cnt = Math.min(cnt, getMin(s + 1, e - 1, a, b));
		} else {
			// 삽입, 삭제
			cnt = Math.min(cnt, getMin(s + 1, e, a, b) + 1);
			cnt = Math.min(cnt, getMin(s, e - 1, a, b) + 1);

			// 어떤 위치에 있는 문자를 교환
			cnt = Math.min(cnt, getMin(s + 1, e - 1, a, b) + 1);

			if (a == b) {
				// 서로다른 문자 교환
				for (int i = s + 1; i < e; i++) {
					if (word[i] == word[s]) {
						swap(i, e);
						cnt = Math.min(cnt, getMin(s + 1, e - 1, i, e) + 1);
						swap(i, e);
					}
					if (word[i] == word[e]) {
						swap(i, s);
						cnt = Math.min(cnt, getMin(s + 1, e - 1, s, i) + 1);
						swap(i, s);
					}
				}
			}
		}

		return dp[s][e][a][b] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		word = br.readLine().toCharArray();

		n = word.length;

		dp = new int[n][n][n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					Arrays.fill(dp[i][j][k], INF);
				}
			}
		}
		int answer = getMin(0, n - 1, 0, 0);

		System.out.println(answer);
	}
}