import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static String[][] dp;
	static int[][] possible;
	static int[][] cake;

	static int choose(int before, int day) {
		if (possible[day][before] != -1)
			return possible[day][before];

		int p = 0;
		for (int c : cake[day]) {
			if (before == c)
				continue;
			p = choose(c, day + 1);
			if (p == 1) {
				dp[day][before] = c + "\n" + dp[day + 1][c];
				break;
			}
		}

		return possible[day][before] = p;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		cake = new int[n][];
		dp = new String[n + 1][10];
		possible = new int[n + 1][10];
		int m, a;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			cake[i] = new int[m];
			for (int j = 0; j < m; j++) {
				a = Integer.parseInt(st.nextToken());
				cake[i][j] = a;
			}
			Arrays.fill(possible[i], -1);
		}

		Arrays.fill(possible[n], 1);
		Arrays.fill(dp[n], "");

		System.out.print(choose(0, 0) == 1 ? dp[0][0] : "-1\n");
	}
}