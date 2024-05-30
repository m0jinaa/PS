import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Stack<Integer> stack = new Stack<>();

		boolean[] v = new boolean[n + 1];

		int x;

		while (m-- > 0) {
			x = Integer.parseInt(br.readLine());

			stack.add(x);
		}

		while (!stack.isEmpty()) {
			x = stack.pop();
			if (v[x])
				continue;
			sb.append(x).append("\n");
			v[x] = true;
		}

		for (int i = 1; i <= n; i++) {
			if (v[i])
				continue;
			v[i] = true;
			sb.append(i).append("\n");
		}

		System.out.print(sb.toString());
	}
}