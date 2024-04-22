import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n;
	static boolean[] v;
	static LinkedList<Integer> q;

	public static int bfs() {
		q.clear();
		q.add(1);
		v[1] = true;
		int cnt = 0;
		int size;
		int now, next;

		end: while (!q.isEmpty()) {
			size = q.size();

			cnt++;
			while (size-- > 0) {
				now = q.poll();

				if (now == n) {
					break end;
				}
				next = now + 1;

				if (next <= n && !v[next]) {
					v[next] = true;
					q.add(next);
				}

				next = 0;

				while (now != 0) {
					next = next * 10 + now % 10;
					now /= 10;
				}

				if (next <= n && !v[next]) {
					v[next] = true;
					q.add(next);
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		q = new LinkedList<>();

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());

			v = new boolean[n + 1];
			sb.append("Case #").append(t).append(": ").append(bfs()).append("\n");
		}

		System.out.print(sb.toString());
	}
}