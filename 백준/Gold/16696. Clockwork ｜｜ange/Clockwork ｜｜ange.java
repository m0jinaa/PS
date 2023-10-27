import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
	static int n;
	static LinkedList<Node> q;
	static HashSet<Long> set;
	static long target;

	static class Node {
		long x;
		int cnt;

		public Node(long x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}
	}

	static int bfs() {

		int answer = -1;

		Node now;
		long next;

		end: while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 1; i < n; i++) {
				next = now.x | (now.x >> i);
				if (!set.contains(next)) {
					if (Long.bitCount(next) == n) {
						answer = now.cnt + 1;
						break end;
					}
					set.add(next);
					q.add(new Node(next, now.cnt + 1));
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		n = input.length();

		long start = Long.parseLong(input, 2);

		int cnt = Long.bitCount(start);

		int answer = -1;

		if (cnt == n)
			answer = 0;
		else {
			q = new LinkedList<>();
			q.add(new Node(start, 0));

			set = new HashSet<>();
			set.add(start);

			answer = bfs();

		}
		System.out.println(answer);
	}
}