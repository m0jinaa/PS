import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int c, n;
	static boolean[][] dp;
	static int[] songs;

	static String getMax() {

		for (int x : songs) {
			for (int i = c; i >= 0; i--) {
				for (int j = c; j >= 0; j--) {
					if (i >= x && dp[i - x][j]) {
						dp[i][j] = true;
					}
					if (j >= x && dp[i][j - x]) {
						dp[i][j] = true;
					}
				}
			}
		}

		int total = 0;
		int l = 0;

		for (int i = 0; i <= c; i++) {
			for (int j = 0; j <= i; j++) {
				if (!dp[i][j] || i + j <= total)
					continue;

				total = i + j;
				l = Math.max(l, i);
			}
		}

		return l + " " + (total - l);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		songs = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			songs[i] = Integer.parseInt(st.nextToken());
		}

		dp = new boolean[c + 1][c + 1];

		dp[0][0] = true;

		String answer = getMax();

		System.out.println(answer);
	}
}