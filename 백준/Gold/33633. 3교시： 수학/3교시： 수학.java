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

		Set<Long> visited = new HashSet<>();

		LinkedList<A> q = new LinkedList<>();
		q.add(new A(n, 1L));
		visited.add(1L);

		A now;
		long nv;
		int qsize;

		while (!q.isEmpty()) {
			visited.clear();
			qsize = q.size();

			while (qsize-- > 0) {
				now = q.poll();

				if (now.i != n && now.v == 1L)
					continue;
				else if (now.i == 1) {
					answer.add(now.v);
					continue;
				}

				if ((now.v - 1) % 3 == 0 && ((now.v - 1) / 3) % 2 != 0) {
					nv = (now.v - 1) / 3;
					if (!visited.contains(nv)) {
						q.add(new A(now.i - 1, nv));
						visited.add(nv);
					}
				}

				nv = now.v * 2;

				if (!visited.contains(nv)) {
					q.add(new A(now.i - 1, nv));
					visited.add(nv);
				}
			}
		}

		Collections.sort(answer);

		sb.append(answer.size()).append("\n");

		for (long ans : answer) {
			sb.append(ans).append("\n");
		}

		System.out.println(sb.toString());
	}
}