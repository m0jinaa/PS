import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int MAX = 101;
	static int n, m;
	static char[] p;
	static char[] file;
	static int[][] dp;

	static int match(int x, int y) {
		if (x >= n && y >= m)
			return 1;
		else if (x >= n)
			return 0;
		else if (y >= m && p[x] != '*') {
			return 0;
		} else if (dp[x][y] != -1) {
			return dp[x][y];
		}

		int ret = 0;

		if (p[x] != '*') {
			if (p[x] == file[y]) {
				ret = match(x + 1, y + 1);
			}
		} else if (y <= m) {
			ret = Math.max(ret, match(x + 1, y));
			ret = Math.max(ret, match(x + 1, y + 1));
			ret = Math.max(ret, match(x, y + 1));
		}

		return dp[x][y] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		p = br.readLine().toCharArray();
		n = p.length;

		int t = Integer.parseInt(br.readLine());
		String input;

		dp = new int[MAX + 1][MAX + 1];

		while (t-- > 0) {
			input = br.readLine();
			file = input.toCharArray();
			m = file.length;

			for (int i = 0; i <= MAX; i++) {
				Arrays.fill(dp[i], -1);
			}

			if (match(0, 0) == 1)
				sb.append(input).append("\n");
		}

		System.out.println(sb.toString());
	}
}