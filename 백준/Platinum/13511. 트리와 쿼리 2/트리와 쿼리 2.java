import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static Edge[][] parent;
	static int[] depth;

	static class Edge {
		int x;
		long c;

		public Edge(int x, long c) {
			super();
			this.x = x;
			this.c = c;
		}

	}

	static ArrayList<Edge>[] graph;

	static void dfs(int x, int d) {
		depth[x] = d;

		for (Edge edge : graph[x]) {
			if (depth[edge.x] != 0)
				continue;
			parent[edge.x][0] = new Edge(x, edge.c);
			dfs(edge.x, d + 1);
		}
	}

	static void setParent() {
		for (int i = 0; i < k; i++) {
			for (int j = 1; j <= n; j++) {
				if (parent[j][i] != null && parent[parent[j][i].x][i] != null) {
					parent[j][i + 1] = new Edge(parent[parent[j][i].x][i].x,
							parent[j][i].c + parent[parent[j][i].x][i].c);
				}
			}
		}
	}

	static Edge lca(int a, int b) {
		if (depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		long cost = 0;
		int v;
		for (int i = k - 1; i >= 0; i--) {
			v = (int) Math.pow(2, i);
			if (v <= depth[b] - depth[a]) {
				cost += parent[b][i].c;
				b = parent[b][i].x;
			}
		}
		if (a == b) {
			return new Edge(a, cost);
		}

		for (int i = k - 1; i >= 0; i--) {
			if (parent[a][i] != null && parent[b][i] != null && parent[a][i].x != parent[b][i].x) {
				cost += parent[a][i].c;
				cost += parent[b][i].c;
				a = parent[a][i].x;
				b = parent[b][i].x;
			}
		}

		cost += parent[a][0].c;
		cost += parent[b][0].c;

		return new Edge(parent[a][0].x, cost);
	}

	static int getNthNode(int a, int b, int c) {

		int v;
		int length;

		while ((length = depth[b] - depth[a] + 1) != c) {
			for (int i = k - 1; i >= 0; i--) {
				v = (int) Math.pow(2, i);
				if (length - v >= c) {
					b = parent[b][i].x;
					break;
				}
			}
		}

		return b;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		k = (int) Math.ceil(Math.log10(n) / Math.log10(2));
		graph = new ArrayList[n + 1];
		parent = new Edge[n + 1][k];
		depth = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		int a, b, c;
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
		}

		dfs(1, 1);

		setParent();

		int m = Integer.parseInt(br.readLine());
		int o, r, t, answer = 0;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			switch (o) {
			case 1:
				sb.append(lca(a, b).c).append("\n");
				break;
			case 2:
				c = Integer.parseInt(st.nextToken());
				r = lca(a, b).x;
				t = depth[a] - depth[r] + 1;
				if (c < t)
					answer = getNthNode(r, a, t - c + 1);
				else if (t == c)
					answer = r;
				else
					answer = getNthNode(r, b, c - (depth[a] - depth[r]));
				sb.append(answer).append("\n");
				break;
			}
		}

		System.out.println(sb.toString());

	}
}