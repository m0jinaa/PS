import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static ArrayList<Integer>[] canGo;
	static int[] dist;

	static void bfs(int start) {
		LinkedList<Integer> q = new LinkedList<>();

		q.add(start);
		dist[start] = 1;

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int next : canGo[now]) {
				if (dist[next] != 0)
					continue;
				dist[next] = dist[now] + 1;
				q.add(next);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new TreeMap<>();

		canGo = new ArrayList[n];
		dist = new int[n];

		for (int i = 0; i < n; i++) {
			canGo[i] = new ArrayList<>();
		}
		int ind = 0;

		int s, e;
		String from, to;

		int start = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " allows travellers from ");
			to = st.nextToken();

			map.putIfAbsent(to, ind);

			e = map.get(to);

			if (e == ind)
				ind++;

			if (i == 0) {
				start = e;
			}
			while (st.hasMoreTokens()) {
				from = st.nextToken();

				map.putIfAbsent(from, ind);

				s = map.get(from);
				if (s == ind)
					ind++;

				canGo[s].add(e);
			}
		}

		bfs(start);

		for (Entry<String, Integer> entry : map.entrySet()) {
			sb.append(dist[entry.getValue()]).append("\n");
		}

		System.out.println(sb.toString());
	}
}