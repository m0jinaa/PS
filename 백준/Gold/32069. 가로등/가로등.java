import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int l, k;
	static LinkedList<Long> q;
	static Map<Long, Long> brightness;
	static StringBuilder sb;

	static void bfs() {
		long now, next;

		while (!q.isEmpty() && k-- > 0) {
			now = q.poll();

			sb.append(brightness.get(now)).append("\n");

			for (int i = -1; i <= 1; i += 2) {
				next = now + i;

				if (next < 0 || next > l || brightness.containsKey(next))
					continue;

				brightness.put(next, brightness.get(now) + 1);
				q.add(next);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");

		l = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		brightness = new HashMap<>();

		q = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");

		long x;

		for (int i = 0; i < n; i++) {
			x = Long.parseLong(st.nextToken());

			q.add(x);
			brightness.put(x, 0L);
		}

		bfs();

		System.out.print(sb.toString());
	}
}