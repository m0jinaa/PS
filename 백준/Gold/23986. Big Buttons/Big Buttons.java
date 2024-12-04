import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		Node[] child;
		boolean end;

		public Node() {
			child = new Node[2];
			end = false;
		}
	}

	static long getCnt(Node now, int c) {
		if (c == 0)
			return 0L;

		long ret = 0L;

		for (int i = 0; i < 2; i++) {
			if (now.child[i] == null)
				ret += (1L << (c - 1));
			else if (now.child[i].end)
				continue;
			else {
				ret += getCnt(now.child[i], c - 1);
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		long answer = 0;

		int n, p;

		char[] prefix;
		int ind;

		Node now;

		for (int t = 1; t <= tc; t++) {

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());

			Node head = new Node();

			while (p-- > 0) {
				prefix = br.readLine().toCharArray();

				now = head;
				for (int c : prefix) {
					ind = c == 'R' ? 0 : 1;

					if (now.child[ind] == null) {
						now.child[ind] = new Node();
					}

					now = now.child[ind];
				}

				now.end = true;
			}

			answer = getCnt(head, n);

			sb.append("Case #").append(t).append(": ").append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}