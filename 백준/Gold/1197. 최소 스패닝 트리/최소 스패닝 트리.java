import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	static class Node implements Comparable<Node> {
		int a, b;
		long c;

		public Node(int a, int b, long c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Node node) {
			if (this.c < node.c)
				return -1;
			else if (this.c > node.c)
				return 1;
			else
				return 0;
		}
	}

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;
		else if (a < b)
			parent[b] = a;
		else
			parent[a] = b;

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		int a, b;
		long c;

		Node[] nodes = new Node[e];

		parent = new int[v + 1];

		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());

			nodes[i] = new Node(a, b, c);
		}

		Arrays.sort(nodes);

		long answer = 0;

		for (Node node : nodes) {
			if (!union(node.a, node.b))
				continue;
			answer += node.c;
		}

		System.out.println(answer);
	}
}