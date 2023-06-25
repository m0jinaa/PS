import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int depth, order;

		public Node(int depth, int order) {
			super();
			this.depth = depth;
			this.order = order;
		}

		@Override
		public String toString() {
			return "[d=" + depth + ", o=" + order + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int c = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		Stack<Node> stack = new Stack();

		int x;
		x = Integer.parseInt(st.nextToken());
		if (x != 1) {
			sb.append("-1");
		} else {
			sb.append(1).append(" ");
			stack.add(new Node(x, 1));
			Node prev;
			
			while (st.hasMoreTokens()) {
				x = Integer.parseInt(st.nextToken());
				prev = stack.peek();
				
				if (prev.depth + 1 == x) {
					sb.append(1).append(" ");
					stack.add(new Node(x, 1));
					continue;
				} else if (prev.depth < x) {
					sb.setLength(0);
					sb.append(-1);
					break;
				}

				while (prev.depth > x) {
					stack.pop();
					prev = stack.peek();
				}
				
				stack.pop();
				prev.order++;
				sb.append(prev.order).append(" ");
				stack.add(prev);

			}
		}

		System.out.println(sb.toString());
	}
}
