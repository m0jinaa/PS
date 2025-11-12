import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int MAX = 17;
	static long[][][][] dp;

	// x : 남아있는 자리수, bef : 이전 높이 (bef == 0이면 시작지점),diff : 높이차가 3인 곳이 있었다면 1 아니면 0,
	// used : 사용된 높이 비트마스킹, cnt : 사용된 높이 종류 개수
	static long getCnt(int x, int bef, int diff, int used, int cnt) {
		if (x == 0) {
			if (diff == 1 && cnt >= 3) {
				return dp[x][bef][diff][used] = 1L;
			} else {
				return dp[x][bef][diff][used] = 0;
			}
		}
		if (dp[x][bef][diff][used] != -1)
			return dp[x][bef][diff][used];

		long ret = 0L;
		int d;
		int nc, nu;

		for (int i = 1; i < 5; i++) {
			d = Math.abs(bef - i);
			nc = (used & (1 << i)) == 0 ? cnt + 1 : cnt;
			nu = used | (1 << i);
			ret += getCnt(x - 1, i, (bef != 0 && d == 3) ? 1 : diff, nu, nc);
		}

		return dp[x][bef][diff][used] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		dp = new long[MAX + 1][5][2][32];

		for (int i = 0; i <= MAX; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 2; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}

		int n;

		while ((n = Integer.parseInt(br.readLine())) != -1) {
			sb.append(n).append(": ").append(getCnt(n, 0, 0, 0, 0)).append("\n");
		}

		System.out.println(sb.toString());
	}
}