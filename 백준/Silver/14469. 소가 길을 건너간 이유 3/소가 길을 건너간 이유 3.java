import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int x, t;

		public Node(int x, int t) {
			super();
			this.x = x;
			this.t = t;
		}

		@Override
		public int compareTo(Node node) {
			return this.x - node.x;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Node[] cows = new Node[n];
		int x, t;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			cows[i] = new Node(x, t);
		}

		Arrays.sort(cows);

		int now = 0;

		for (Node cow : cows) {
			if (cow.x < now)
				now += cow.t;
			else
				now = cow.x + cow.t;
		}

		System.out.println(now);
	}
}