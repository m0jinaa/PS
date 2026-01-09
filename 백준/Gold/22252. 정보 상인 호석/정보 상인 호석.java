import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int ind = 0;
	static Map<String, Integer> map;

	static int getInd(String name) {
		if (!map.containsKey(name))
			map.put(name, ind++);

		return map.get(name);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MAX = 1_000_000;
		map = new HashMap<>();

		int q = Integer.parseInt(br.readLine());

		long cost = 0;

		PriorityQueue<Integer>[] gorilla = new PriorityQueue[MAX];

		String name;
		int o, k, b, c, x, p;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());
			name = st.nextToken();

			if (o == 1) {
				k = Integer.parseInt(st.nextToken());

				x = getInd(name);

				if (gorilla[x] == null) {
					gorilla[x] = new PriorityQueue<>(Collections.reverseOrder());
				}

				while (k-- > 0) {
					c = Integer.parseInt(st.nextToken());

					gorilla[x].add(c);
				}
			} else {
				b = Integer.parseInt(st.nextToken());

				x = getInd(name);

				if (gorilla[x] == null)
					continue;

				while (!gorilla[x].isEmpty() && b-- > 0) {
					p = gorilla[x].poll();

					cost += p;
				}
			}
		}

		System.out.println(cost);
	}
}