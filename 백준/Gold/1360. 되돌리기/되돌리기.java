import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Order {
		String o, w;
		int t, at;

		public Order(String o, String w, int at) {
			super();
			this.o = o;
			this.w = w;
			this.at = at;
		}

		public Order(String o, int t, int at) {
			super();
			this.o = o;
			this.t = t;
			this.at = at;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Stack<Order> orders = new Stack<>();
		Stack<String> answer = new Stack<>();

		String o, w;
		int t, at;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = st.nextToken();

			if ("type".equals(o)) {
				w = st.nextToken();
				at = Integer.parseInt(st.nextToken());

				orders.add(new Order(o, w, at));
			} else {
				t = Integer.parseInt(st.nextToken());
				at = Integer.parseInt(st.nextToken());

				orders.add(new Order(o, t, at));
			}
		}

		Order now;
		int bef = 1_000_000_007;

		while (!orders.isEmpty()) {
			now = orders.pop();

			if (now.at >= bef)
				continue;
			else if ("type".equals(now.o)) {
				answer.add(now.w);
			} else {
				bef = now.at - now.t;
			}
		}

		while (!answer.isEmpty()) {
			sb.append(answer.pop());
		}

		System.out.println(sb.toString());
	}
}