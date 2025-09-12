import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		Node bef;
		int x;

		public Node(Node bef, int x) {
			super();
			this.bef = bef;
			this.x = x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Node[] history = new Node[n + 1];

		Node now = new Node(null, -1);

		String o;
		int x, k;

		for (int i = 1; i <= n; i++) {
			history[i] = now;

			st = new StringTokenizer(br.readLine(), " ");

			o = st.nextToken();

			switch (o) {
			case "a":
				x = Integer.parseInt(st.nextToken());
				now = new Node(now, x);
				break;
			case "s":
				now = now.bef;
				break;
			case "t":
				k = Integer.parseInt(st.nextToken());
				now = history[k];
				break;
			}

			sb.append(now.x).append("\n");
		}

		System.out.print(sb.toString());
	}
}