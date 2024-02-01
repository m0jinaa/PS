import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] dp;
	static int[] gate;
	static boolean[] changible;
	static int[] value;
	static final int INF = 1_000_000_007;
	static final int MAX = 99999;

	public static int getMin(int x, int v) {
		if (dp[x][v] != INF)
			return dp[x][v];
		else if (value[x] == v)
			return dp[x][v] = 0;
		int ret = MAX;
		int or, and;
		// 현재위치의 게이트를 바꿔서 해결할 수 있는지 확인
		if (changible[x]) {
			or = value[2 * x] | value[2 * x + 1];
			and = value[2 * x] & value[2 * x + 1];

			if (or == v || and == v) {
				ret = 1;
			} else {
				if (1 - gate[x] == 1 && v == 1) {
					ret = Math.min(ret, getMin(2 * x, 1) + getMin(2 * x + 1, 1) + 1);
				} else if (1 - gate[x] == 1 && v == 0) {
					ret = Math.min(ret, getMin(2 * x, 0) + getMin(2 * x + 1, 1) + 1);
					ret = Math.min(ret, getMin(2 * x, 1) + getMin(2 * x + 1, 0) + 1);
					ret = Math.min(ret, getMin(2 * x, 0) + getMin(2 * x + 1, 0) + 1);
				} else if (1 - gate[x] == 0 && v == 1) {
					ret = Math.min(ret, getMin(2 * x, 1) + getMin(2 * x + 1, 1) + 1);
					ret = Math.min(ret, getMin(2 * x, 1) + getMin(2 * x + 1, 0) + 1);
					ret = Math.min(ret, getMin(2 * x, 0) + getMin(2 * x + 1, 1) + 1);
				} else if (1 - gate[x] == 0 && v == 0) {
					ret = Math.min(ret, getMin(2 * x, 0) + getMin(2 * x + 1, 0) + 1);
				}
			}
		}

		// 하위노드의 게이트만 바꿔서 해결할 수 있는지 확인
		if (x <= m) {
			if (gate[x] == 1 && v == 1) {
				ret = Math.min(ret, getMin(2 * x, 1) + getMin(2 * x + 1, 1));
			} else if (gate[x] == 1 && v == 0) {
				ret = Math.min(ret, getMin(2 * x, 0) + getMin(2 * x + 1, 1));
				ret = Math.min(ret, getMin(2 * x, 1) + getMin(2 * x + 1, 0));
				ret = Math.min(ret, getMin(2 * x, 0) + getMin(2 * x + 1, 0));
			} else if (gate[x] == 0 && v == 1) {
				ret = Math.min(ret, getMin(2 * x, 1) + getMin(2 * x + 1, 1));
				ret = Math.min(ret, getMin(2 * x, 1) + getMin(2 * x + 1, 0));
				ret = Math.min(ret, getMin(2 * x, 0) + getMin(2 * x + 1, 1));
			} else if (gate[x] == 0 && v == 0) {
				ret = Math.min(ret, getMin(2 * x, 0) + getMin(2 * x + 1, 0));
			}
		}
		return dp[x][v] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int v, g, c, l, answer;
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			dp = new int[n + 1][2];
			changible = new boolean[n + 1];
			gate = new int[n + 1];
			value = new int[n + 1];

			Arrays.fill(gate, -1);

			m = (n - 1) / 2;

			for (int i = 1; i <= m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				g = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());

				gate[i] = g;
				changible[i] = c == 1 ? true : false;
				dp[i][0] = INF;
				dp[i][1] = INF;
			}

			for (int i = m + 1; i <= n; i++) {
				l = Integer.parseInt(br.readLine());
				value[i] = l;
				dp[i][0] = INF;
				dp[i][1] = INF;
			}

			for (int i = m; i >= 1; i--) {
				switch (gate[i]) {
				case 1:
					value[i] = value[2 * i] & value[2 * i + 1];
					break;
				case 0:
					value[i] = value[2 * i] | value[2 * i + 1];
					break;
				}
			}

			answer = getMin(1, v);
			sb.append("Case #").append(t).append(": ").append(answer == MAX ? "IMPOSSIBLE" : answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}