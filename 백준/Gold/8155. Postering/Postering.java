import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		int d, w;
		int cnt = 0;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty() && stack.peek() > w) {
				stack.pop();
				cnt++;
			}
			if (!stack.isEmpty() && stack.peek() == w)
				continue;
			else
				stack.push(w);

		}

		cnt += stack.size();

		System.out.println(cnt);

	}
}