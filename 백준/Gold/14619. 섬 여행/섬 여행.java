import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] height;
	static int[][] dp;
	static ArrayList<Integer>[] canGo;
	static final int INF = 10001;

	static int getLowest(int x, int d) {
		if (dp[x][d] != -2) {
			return dp[x][d];
		} else if (d == 0) {
			return dp[x][d] = height[x];
		}

		int min = INF;
		int temp;
		for (int y : canGo[x]) {
			temp = getLowest(y, d - 1);
			if (temp == -1)
				continue;
			min = Math.min(min, getLowest(y, d - 1));
		}

		return dp[x][d] = (min == INF) ? -1 : min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		height = new int[n + 1];
		canGo = new ArrayList[n + 1];
		dp = new int[n + 1][501];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			canGo[i] = new ArrayList<>();
			Arrays.fill(dp[i], -2);
		}

		int x, y;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			canGo[x].add(y);
			canGo[y].add(x);
		}

		int q = Integer.parseInt(br.readLine());
		int a, k;
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			sb.append(getLowest(a, k)).append("\n");
		}

		System.out.print(sb.toString());
	}
}
