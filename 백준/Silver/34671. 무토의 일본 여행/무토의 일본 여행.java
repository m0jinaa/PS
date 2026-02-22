import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		Map<Long, Integer> road = new HashMap<>();

		long a, b;
		int c;

		long loc;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			loc = a * n + b;

			if (road.containsKey(loc)) {
				road.put(loc, Math.min(c, road.get(loc)));
			} else {
				road.put(loc, c);
			}

			loc = b * n + a;

			if (road.containsKey(loc)) {
				road.put(loc, Math.min(c, road.get(loc)));
			} else {
				road.put(loc, c);
			}
		}

		long s, e;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Long.parseLong(st.nextToken());
			e = Long.parseLong(st.nextToken());

			loc = s * n + e;

			sb.append(road.getOrDefault(loc, -1)).append("\n");
		}

		System.out.print(sb.toString());
	}
}