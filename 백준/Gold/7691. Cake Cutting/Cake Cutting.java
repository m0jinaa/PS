import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][][] dp;
	static int MAX = 20;
	static final int INF = 1_000_000_007;

	static int getMin(int x, int y, int z) {
		if (dp[x][y][z] != 0)
			return dp[x][y][z];
		else if (z == 1)
			return dp[x][y][z] = x * y;
		else if (x * y == z)
			return dp[x][y][z] = 1;
		else if (x * y < z)
			return dp[x][y][z] = INF;

		int min = INF;

		// 가로로 자르기
		for (int i = 1; i < x; i++) {
			for (int j = 1; j < z; j++) {
				min = Math.min(min, Math.max(getMin(i, y, j), getMin(x - i, y, z - j)));
			}
		}

		// 세로로 자르기
		for (int i = 1; i < y; i++) {
			for (int j = 1; j < z; j++) {
				min = Math.min(min, Math.max(getMin(x, i, j), getMin(x, y - i, z - j)));
			}
		}

		return dp[x][y][z] = min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		dp = new int[MAX + 1][MAX + 1][MAX * MAX + 1];

		int x, y, z;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());

			if (x == 0 && y == 0 && z == 0)
				break;

			sb.append(getMin(x, y, z)).append("\n");
		}

		System.out.print(sb.toString());
	}
}