import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static ArrayList<Node>[] canGo;
	static int end, max;
	static int[] value;
	static int[] after;
	static int[] dp;
	static int[] cnt;
	static final int INF = 1_000_000_007;
	static class Node {
		int x, cost;

		public Node(int x, int cost) {
			super();
			this.x = x;
			this.cost = cost;
		}

	}

	static int getMax(int x) {
		if (dp[x] != INF)
			return dp[x];
		int sum = value[x];
		int temp;
		int c = 1;
		for (Node next : canGo[x]) {
			temp = getMax(next.x) - next.cost+value[x];
			if (sum < temp) {
				sum = temp;
				cnt[x] = cnt[next.x]+1;
				after[x] = next.x;
			}
		}
		
		return dp[x] = sum;
	}

	static void trace() {
		int x = 1;
		sb.append(dp[x]).append(" ").append(cnt[x]).append("\n");
		while (x != 0) {
			sb.append(x).append(" ");
			x = after[x];
		}
		sb.append("\n");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		int n, e, a, b, c;

		while (t-- > 0) {

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			value = new int[n + 1];
			dp = new int[n + 1];
			after = new int[n + 1];
			cnt = new int[n + 1];
			canGo = new ArrayList[n + 1];

			Arrays.fill(dp, INF);
			Arrays.fill(cnt, 1);
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= n; i++) {
				value[i] = Integer.parseInt(st.nextToken());
				canGo[i] = new ArrayList<>();
			}

			while (e-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());

				canGo[a].add(new Node(b, c));
			}

			getMax(1);

			trace();
		}

		System.out.print(sb.toString());
	}
}