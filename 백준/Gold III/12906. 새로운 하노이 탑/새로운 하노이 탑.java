import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static HashSet<String> set;

	static class Node {
		String a, b, c;
		int t;

		public Node(String a, String b, String c, int t) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
			this.t = t;
		}

		public boolean reg() {
			String s = a + " " + b + " " + c;
			if (set.contains(s))
				return false;

			set.add(s);
			return true;
		}

		public boolean check() {
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) != 'A')
					return false;
			}
			for (int i = 0; i < b.length(); i++) {
				if (b.charAt(i) != 'B')
					return false;
			}
			for (int i = 0; i < c.length(); i++) {
				if (c.charAt(i) != 'C')
					return false;
			}
			return true;
		}
	}

	static int bfs(String a, String b, String c) {
		int answer = -1;

		LinkedList<Node> q = new LinkedList<>();

		Node now, next;
		now = new Node(a, b, c, 0);
		q.add(now);

		now.reg();

		String na, nb, nc;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.check()) {
				answer = now.t;
				break;
			}

			if (now.a.length() != 0) {
				// a->b
				na = now.a.length() > 1 ? now.a.substring(1) : "";
				nb = now.a.charAt(0) + now.b;
				nc = now.c.length() > 0 ? now.c.substring(0) : "";

				next = new Node(na, nb, nc, now.t + 1);

				if (next.reg()) {
					q.add(next);
				}

				// a->c
				na = now.a.length() > 1 ? now.a.substring(1) : "";
				nb = now.b.length() > 0 ? now.b.substring(0) : "";
				nc = now.a.charAt(0) + now.c;

				next = new Node(na, nb, nc, now.t + 1);

				if (next.reg()) {
					q.add(next);
				}
			}

			if (now.b.length() != 0) {
				// b->a
				na = now.b.charAt(0) + now.a;
				nb = now.b.length() > 1 ? now.b.substring(1) : "";
				nc = now.c.length() > 0 ? now.c.substring(0) : "";

				next = new Node(na, nb, nc, now.t + 1);

				if (next.reg()) {
					q.add(next);
				}

				// b->c
				na = now.a.length() > 0 ? now.a.substring(0) : "";
				nb = now.b.length() > 1 ? now.b.substring(1) : "";
				nc = now.b.charAt(0) + now.c;

				next = new Node(na, nb, nc, now.t + 1);

				if (next.reg()) {
					q.add(next);
				}
			}

			if (now.c.length() != 0) {
				// c->a
				na = now.c.charAt(0) + now.a;
				nb = now.b.length() > 0 ? now.b.substring(0) : "";
				nc = now.c.length() > 1 ? now.c.substring(1) : "";

				next = new Node(na, nb, nc, now.t + 1);

				if (next.reg()) {
					q.add(next);
				}

				// c->b
				na = now.a.length() > 0 ? now.a.substring(0) : "";
				nb = now.c.charAt(0) + now.b;
				nc = now.c.length() > 1 ? now.c.substring(1) : "";

				next = new Node(na, nb, nc, now.t + 1);

				if (next.reg()) {
					q.add(next);
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String a, b, c;

		st = new StringTokenizer(br.readLine(), " ");
		if ("0".equals(st.nextToken()))
			a = "";
		else {
			sb.append(st.nextToken());
			sb = sb.reverse();
			a = sb.toString();
			sb.setLength(0);
		}

		st = new StringTokenizer(br.readLine(), " ");
		if ("0".equals(st.nextToken()))
			b = "";
		else {
			sb.append(st.nextToken());
			sb = sb.reverse();
			b = sb.toString();
			sb.setLength(0);
		}

		st = new StringTokenizer(br.readLine(), " ");
		if ("0".equals(st.nextToken()))
			c = "";
		else {
			sb.append(st.nextToken());
			sb = sb.reverse();
			c = sb.toString();
			sb.setLength(0);
		}

		set = new HashSet<>();

		int answer = bfs(a, b, c);

		System.out.println(answer);
	}
}