import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] connected;
	static int[] dp;
	static boolean[] visited;

	static int getMax(int x) {
		if (dp[x] != -1)
			return dp[x];

		int v = -1;

		for (int y : connected[x]) {
			if (visited[y])
				continue;
			visited[y] = true;
			v = Math.max(v, getMin(y));
		}

		return dp[x] = v;
	}

	static int getMin(int x) {
		if (dp[x] != -1)
			return dp[x];

		int v = 1_000_000_007;

		for (int y : connected[x]) {
			if (visited[y])
				continue;
			visited[y] = true;
			v = Math.min(v, getMax(y));
		}

		return dp[x] = v;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		connected = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			connected[i] = new ArrayList<>();
		}

		Arrays.fill(dp, -1);

		int a, b;
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			connected[a].add(b);
			connected[b].add(a);
		}

		int l = Integer.parseInt(br.readLine());

		int k, t;

		while (l-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			k = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			dp[k] = t;
		}

		visited[r] = true;

		getMax(r);// 0: max, 1: min

		int q = Integer.parseInt(br.readLine());

		int x;

		while (q-- > 0) {
			x = Integer.parseInt(br.readLine());
			sb.append(dp[x]).append("\n");
		}

		System.out.print(sb.toString());
	}
}