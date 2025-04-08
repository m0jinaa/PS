import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_007;
	static int n;
	static int[] dp;
	static boolean[] visited;
	static ArrayList<Vine>[] connectedTo;

	static class Vine {
		int x, v;

		public Vine(int x, int v) {
			super();
			this.x = x;
			this.v = v;
		}
	}

	static int getMin(int x) {
		if (dp[x] != -1)
			return dp[x];
		int cost = 0;

		boolean last = true;

		for (Vine vine : connectedTo[x]) {
			if (visited[vine.x])
				continue;
			last = false;
			visited[vine.x] = true;
			cost += Math.min(vine.v, getMin(vine.x));
			visited[vine.x] = false;
		}

		return dp[x] = last ? INF : cost;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		connectedTo = new ArrayList[n + 1];
		dp = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			connectedTo[i] = new ArrayList<>();
			dp[i] = -1;
		}

		int a, b, v;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			connectedTo[a].add(new Vine(b, v));
			connectedTo[b].add(new Vine(a, v));
		}

		visited[1] = true;

		int answer = getMin(1);

		System.out.println(answer);
	}
}