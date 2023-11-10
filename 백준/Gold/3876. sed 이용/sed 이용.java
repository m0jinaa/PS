import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static String target;
	static Rule[] rules;
	static HashSet<String> set;

	static class Rule {
		String a, b;

		public Rule(String a, String b) {
			super();
			this.a = a;
			this.b = b;
		}
	}

	static class Node {
		String s;
		int c;

		public Node(String s, int c) {
			super();
			this.s = s;
			this.c = c;
		}
	}

	static int bfs(String start) {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(start, 0));
		set.clear();
		set.add(start);

		Node now;
		String next;
		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (target.equals(now.s)) {
				answer = now.c;
				break;
			}

			for (Rule r : rules) {
				next = now.s.replaceAll(r.a, r.b);

				if (set.contains(next) || next.length() > target.length())
					continue;
				set.add(next);

				q.add(new Node(next, now.c + 1));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n, answer;
		String start;
		set = new HashSet<>();

		while (true) {
			n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;

			rules = new Rule[n];

			String a, b;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				a = st.nextToken();
				b = st.nextToken();

				rules[i] = new Rule(a, b);
			}

			start = br.readLine();

			target = br.readLine();

			answer = bfs(start);

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}