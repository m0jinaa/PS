import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		LinkedList<Long> q = new LinkedList<>();

		long now;
		int qsize, t = 0;

		int answer = 0;

		Set<Long> v = new HashSet<>();
		q.add(n);
		v.add(n);
		long nx;

		end: while (!q.isEmpty()) {
			qsize = q.size();

			while (qsize-- > 0) {
				now = q.poll();

				if (now == 1L) {
					answer = t;
					break end;
				}
				nx = now / 3;
				if (now % 3 == 0 && !v.contains(nx)) {
					q.add(nx);
					v.add(nx);
				}

				nx = now / 2;
				if (now % 2 == 0 && !v.contains(nx)) {
					q.add(nx);
					v.add(nx);
				}

				nx = now - 1;
				if (!v.contains(nx)) {
					q.add(nx);
					v.add(nx);
				}

			}
			t++;
		}

		System.out.println(answer);
	}
}