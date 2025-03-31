import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MAX_TURN = 40;
	static int[][][][] dp;

	// 1~3번 항아리에 각각 a,b,c개가 있고 d개를 가져가야 할 때 F가 가져갈 수 있는 pebble의 최대값 구하기
	static int getPebble(int a, int b, int c, int d) {
		if (dp[a][b][c][d] != -1)
			return dp[a][b][c][d];

		int pa = Math.min(a, d);
		int pb = Math.min(b, d);
		int pc = Math.min(c, d);

		int p;

		if (d % 2 != 0) {
			p = 0;
			if (pa != 0)
				p = Math.max(p, getPebble(a - pa, b, c, d + 1) + pa);
			if (pb != 0)
				p = Math.max(p, getPebble(a, b - pb, c, d + 1) + pb);
			if (pc != 0)
				p = Math.max(p, getPebble(a, b, c - pc, d + 1) + pc);
		} else {
			p = a + b + c + 1;

			if (pa != 0)
				p = Math.min(p, getPebble(a - pa, b, c, d + 1));
			if (pb != 0)
				p = Math.min(p, getPebble(a, b - pb, c, d + 1));
			if (pc != 0)
				p = Math.min(p, getPebble(a, b, c - pc, d + 1));
		}

		return dp[a][b][c][d] = p;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		dp = new int[a + 1][b + 1][c + 1][MAX_TURN + 1];

		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				for (int k = 0; k <= c; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}

		Arrays.fill(dp[0][0][0], 0);

		int f = getPebble(a, b, c, 1);

		int s = a + b + c - f;

		System.out.println(f > s ? "F" : f < s ? "S" : "D");
	}
}