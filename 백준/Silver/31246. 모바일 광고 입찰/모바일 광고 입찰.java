import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int a, b;

		public Node(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Node node) {
			return (this.b - this.a) - (node.b - node.a);

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Node[] nodes = new Node[n];

		int a, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			nodes[i] = new Node(a, b);
		}

		Arrays.sort(nodes);

		int answer = 0;

		answer = Math.max(answer, nodes[k - 1].b - nodes[k - 1].a);

		System.out.println(answer);
	}
}