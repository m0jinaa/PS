import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {
	static class A {
		int i;
		long v;

		public A(int i, long v) {
			super();
			this.i = i;
			this.v = v;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		LinkedList<Long> answer = new LinkedList<>();

		Set<A> visited = new HashSet<>();

		LinkedList<A> q = new LinkedList<>();
		q.add(new A(n, 1L));
		visited.add(new A(n, 1));

		A now;
		A next;
		while (!q.isEmpty()) {
			now = q.poll();

			if (now.i != n && now.v == 1L)
				continue;
			else if (now.i == 1) {
				answer.add(now.v);
				continue;
			}

			if ((now.v - 1) % 3 == 0 && ((now.v - 1) / 3) % 2 != 0) {
				next = new A(now.i - 1, (now.v - 1) / 3);
				q.add(next);
				visited.add(next);
			}

			next = new A(now.i - 1, now.v * 2);

			q.add(next);
			visited.add(next);
		}

		Collections.sort(answer);

		sb.append(answer.size()).append("\n");

		while (!answer.isEmpty()) {
			sb.append(answer.poll()).append("\n");
		}

		System.out.println(sb.toString());
	}
}