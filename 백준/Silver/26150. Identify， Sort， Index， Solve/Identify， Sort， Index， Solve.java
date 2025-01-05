import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		String s;
		int ind;

		public Node(String s, int ind) {
			super();
			this.s = s;
			this.ind = ind;
		}

		@Override
		public int compareTo(Node node) {
			return this.ind - node.ind;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Node[] nodes = new Node[n];

		String s;
		int ind, d;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = st.nextToken();
			ind = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			nodes[i] = new Node(s.substring(d - 1, d), ind);
		}

		Arrays.sort(nodes);

		String answer = "";

		for (Node node : nodes) {
			answer += node.s;
		}

		answer = answer.toUpperCase();

		System.out.println(answer);
	}
}