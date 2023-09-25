import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] dp;
	static char[] board;
	static char[] word;
	static int[] dx = new int[] { 1, -1 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static int getMax(int x, int y) {
		if (dp[x][y] != -1)
			return dp[x][y];

		int score = 0;
		int nx;
		for (int i = 0; i < 2; i++) {
			nx = x + dx[i];
			if (!inRange(nx, y + 1))
				continue;
			score = Math.max(score, getMax(nx, y + 1));
		}

		return dp[x][y] = score + (board[x] == word[y] ? 1 : 0);

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = br.readLine().toCharArray();
		word = br.readLine().toCharArray();

		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, getMax(i, 0));
		}

		System.out.println(answer);
	}
}