import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int q = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		Stack<Integer> save = new Stack<>();

		int o;
		int x, bef;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());

			switch (o) {
			case 1:
				x = Integer.parseInt(st.nextToken());
				stack.add(x);
				save.add(-1);
				break;
			case 2:
				save.add(stack.pop());
				break;
			case 3:
				x = Integer.parseInt(st.nextToken());
				while (x-- > 0) {
					bef = save.pop();
					if (bef == -1) {
						stack.pop();
					} else {
						stack.add(bef);
					}
				}
				break;
			case 4:
				sb.append(stack.size()).append("\n");
				break;
			case 5:
				sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
				break;
			}
		}

		System.out.println(sb.toString());
	}
}