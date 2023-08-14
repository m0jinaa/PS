import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		int o, x;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());

			switch (o) {
			case 1:
				x = Integer.parseInt(st.nextToken());
				stack.push(x);
				break;
			case 2:
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
				break;
			case 3:
				sb.append(stack.size()).append("\n");
				break;
			case 4:
				sb.append(stack.isEmpty() ? "1" : "0").append("\n");
				break;
			case 5:
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.peek()).append("\n");
				}
				break;
			}
		}
		System.out.print(sb.toString());
	}
}