import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int x, k;
		long c;

		public Node(int x, int k, long c) {
			super();
			this.x = x;
			this.k = k;
			this.c = c;
		}

		@Override
		public int compareTo(Node node) {
			return this.c < node.c ? -1 : 1;
		}
	}

	static class Edge {
		int x, ind;

		public Edge(int x, int ind) {
			super();
			this.x = x;
			this.ind = ind;
		}
	}

	static int n, m;
	static long[][] T;
	static ArrayList<Edge>[] connectedTo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MAX = 100;
		final long INF = Long.MAX_VALUE;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		connectedTo = new ArrayList[n + 1];

		T = new long[MAX + 1][m];

		for (int i = 1; i <= n; i++) {
			connectedTo[i] = new ArrayList<>();
		}

		int u, v, t;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			T[0][i] = t;
			connectedTo[u].add(new Edge(v, i));
			connectedTo[v].add(new Edge(u, i));
		}

		int k = Integer.parseInt(br.readLine());

		long[][] cost = new long[k + 1][n + 1];

		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			Arrays.fill(cost[i], INF);

			for (int j = 0; j < m; j++) {
				T[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.fill(cost[0], INF);

		PriorityQueue<Node> q = new PriorityQueue<>();

		q.add(new Node(a, 0, 0));

		cost[0][a] = 0;

		Node now;

		long nc;

		while (!q.isEmpty()) {
			now = q.poll();

			if (cost[now.k][now.x] < now.c)
				continue;

			for (Edge e : connectedTo[now.x]) {

				for (int nk = now.k; nk <= k; nk++) {
					nc = now.c + T[nk][e.ind];

					if (cost[nk][e.x] <= nc)
						continue;
					cost[nk][e.x] = nc;
					q.add(new Node(e.x, nk, nc));
				}
			}
		}

		long answer = INF;

		for (int i = 0; i <= k; i++) {
			answer = Math.min(answer, cost[i][b]);
		}

		System.out.println(answer);
	}
}