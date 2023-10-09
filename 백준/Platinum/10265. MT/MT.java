import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k, c;
	static int[] done, depend, cycle;
	static boolean[] v, dp;
	static int[][] range;

	static int dfs(int x) {
		v[x] = true;

		if (!v[depend[x]]) {
			return done[x] = dfs(depend[x]);
		} else if (done[depend[x]] == 0) {
			c++;
			cycle[x] = c;

			for (int y = depend[x]; y != x; y = depend[y]) {
				cycle[y] = c;
			}

			return done[x] = c;
		} else {
			return done[x] = done[depend[x]];
		}
	}

	static int getMax() {
		dp[0] = true;

		for (int i = 1; i <= c; i++) {
			for (int j = k; j >= 0; j--) {
				for (int h = range[i][0]; h <= range[i][1]; h++) {
					if (j < h)
						break;
					dp[j] |= dp[j - h];

				}
			}
		}

		int answer = 0;

		for (int i = k; i >= 0; i--) {
			if (!dp[i])
				continue;
			answer = i;
			break;
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new boolean[k + 1];

		depend = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			depend[i] = Integer.parseInt(st.nextToken());
		}

		done = new int[n + 1];
		cycle = new int[n + 1];
		v = new boolean[n + 1];
		range = new int[n + 1][2];

		for (int i = 1; i <= n; i++) {
			if (!v[i])
				dfs(i);
		}

		for (int i = 1; i <= n; i++) {
			range[cycle[i]][0]++;
			range[done[i]][1]++;
		}

		int answer = getMax();

		System.out.println(answer);
	}
}