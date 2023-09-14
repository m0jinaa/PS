import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static boolean[][][] dp;
	static ArrayList<Node>[][] canGo;

	static class Node {
		int c, x, t;

		public Node(int x, int t) {
			super();
			this.x = x;
			this.t = t;
		}

		public Node(int c, int x, int t) {
			super();
			this.c = c;
			this.x = x;
			this.t = t;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int a, b, c, d;

		canGo = new ArrayList[n + 1][2];
		dp = new boolean[2][n + 1][10001];

		for (int i = 1; i <= n; i++) {
			canGo[i][0] = new ArrayList<>();
			canGo[i][1] = new ArrayList<>();
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			canGo[a][0].add(new Node(b, c));
			canGo[a][1].add(new Node(b, d));
		}

		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(0, 1, 0));
		q.add(new Node(1, 1, 0));

		dp[0][1][0] = true;
		dp[1][1][0] = true;

		Node now;
		int nt;
		while (!q.isEmpty()) {
			now = q.poll();

			for (Node next : canGo[now.x][now.c]) {
				nt = now.t + next.t;

				if (dp[now.c][next.x][nt])
					continue;
				dp[now.c][next.x][nt] = true;
				q.add(new Node(now.c, next.x, nt));
			}
		}

		int answer = -1;

		for (int i = 0; i < 10001; i++) {
			if (dp[0][n][i] && dp[1][n][i]) {
				answer = i;
				break;
			}
		}

		System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);

	}
}