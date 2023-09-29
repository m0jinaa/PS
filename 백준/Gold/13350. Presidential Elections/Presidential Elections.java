import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x, c;

		public Node(int x, int c) {
			super();
			this.x = x;
			this.c = c;
		}
	}

	static ArrayList<Node> list;
	static int[] dp;
	static final int INF = 1_000_000_007;

	static int getMin(int x) {

		Arrays.fill(dp, INF);

		dp[0] = 0;

		for (Node node : list) {
			for (int i = 2016; i >= node.x; i--) {
				dp[i] = Math.min(dp[i], dp[i - node.x] + node.c);
			}
		}
		int answer = INF;

		for (int i = x; i <= 2016; i++) {
			answer = Math.min(answer, dp[i]);
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int dSum = 0, cSum = 0;

		int d, c, f, u;
		int total;

		list = new ArrayList<>();

		dp = new int[2017];

		int t;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			f = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());

			total = c + f + u;
			dSum += d;

			if (c > f + u) {
				cSum += d;
			} else if (c + u > f) {

				t = total / 2 + 1 - c;

				list.add(new Node(d, t));
			}
		}

		int target = dSum / 2 + 1 - cSum;
        
		int answer;

		if (target < 0)
			answer = 0;
		else
			answer = getMin(target);

		System.out.println(answer == INF ? "impossible" : answer);
	}
}