import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Stack<Integer> dirty = new Stack<>();
		Stack<Integer> washed = new Stack<>();
		Stack<Integer> dried = new Stack<>();

		int n = Integer.parseInt(br.readLine());

		for (int i = n; i > 0; i--) {
			dirty.add(i);
		}

		int c, d;

		while (dried.size() != n) {
			st = new StringTokenizer(br.readLine(), " ");
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			if (c == 1) {
				while (d-- > 0) {
					washed.add(dirty.pop());
				}
			} else if (c == 2) {
				while (d-- > 0) {
					dried.add(washed.pop());
				}
			}
		}

		while (!dried.isEmpty()) {
			sb.append(dried.pop()).append("\n");
		}

		System.out.print(sb.toString());
	}
}