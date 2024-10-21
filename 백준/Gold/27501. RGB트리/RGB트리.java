import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static char[] path;
	static int[][] beauty;
	static int[][] dp;
	static ArrayList<Integer>[] connected;

	static int getMax(int x, int t, int p) {
		if (dp[x][t] != 0)
			return dp[x][t];

		int ret = beauty[x][t];

		int max;

		for (int y : connected[x]) {
			if (y == p)
				continue;

			max = 0;

			for (int i = 0; i < 3; i++) {
				if (t == i)
					continue;
				max = Math.max(max, getMax(y, i, x));
			}

			ret += max;
		}

		return dp[x][t] = ret;
	}

	static void track(int x, int t, int p) {
		path[x] = (t == 0 ? 'R' : (t == 1 ? 'G' : 'B'));

		for (int y : connected[x]) {
			if (y == p)
				continue;
			else if (t == 0) {
				track(y, dp[y][1] > dp[y][2] ? 1 : 2, x);
			} else if (t == 1) {
				track(y, dp[y][0] > dp[y][2] ? 0 : 2, x);
			} else if (t == 2) {
				track(y, dp[y][1] > dp[y][0] ? 1 : 0, x);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int x, y;

		connected = new ArrayList[n + 1];

		dp = new int[n + 1][3];
		beauty = new int[n + 1][3];
		path = new char[n + 1];

		for (int i = 1; i <= n; i++) {
			connected[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			connected[x].add(y);
			connected[y].add(x);
		}

		int r, g, b;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			r = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			beauty[i][0] = r;
			beauty[i][1] = g;
			beauty[i][2] = b;
		}

		int answer = Math.max(getMax(1, 0, 1), Math.max(getMax(1, 1, 1), getMax(1, 2, 1)));

		for (int i = 0; i < 3; i++) {
			if (dp[1][i] != answer)
				continue;
			track(1, i, 1);
			break;
		}

		sb.append(answer).append("\n");

		for (int i = 1; i <= n; i++) {
			sb.append(path[i]);
		}

		System.out.println(sb.toString());
	}
}