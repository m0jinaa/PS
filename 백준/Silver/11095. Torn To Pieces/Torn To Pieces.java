import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<String, Integer> map;
	static int[] bef;
	static ArrayList<Integer>[] canGo;
	static String[] name;
	static int ind = 1;

	static int getInd(String x) {
		if (!map.containsKey(x)) {
			map.put(x, ind);
			name[ind] = x;
			ind++;
		}

		return map.get(x);
	}

	static void bfs(int x) {
		LinkedList<Integer> q = new LinkedList<>();

		q.add(x);
		bef[x] = 0;

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int next : canGo[now]) {
				if (bef[next] != -1)
					continue;
				bef[next] = now;
				q.add(next);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		canGo = new ArrayList[2 * n + 1];
		map = new HashMap<>();
		name = new String[2 * n + 1];

		for (int i = 1; i <= 2 * n; i++) {
			canGo[i] = new ArrayList<>();
		}

		String start, end;
		int s, e;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			start = st.nextToken();
			s = getInd(start);

			while (st.hasMoreElements()) {
				end = st.nextToken();
				e = getInd(end);

				canGo[e].add(s);
				canGo[s].add(e);
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		start = st.nextToken();
		end = st.nextToken();

		s = getInd(start);
		e = getInd(end);

		bef = new int[2 * n + 1];

		Arrays.fill(bef, -1);

		bfs(e);

		if (bef[s] == -1) {
			sb.append("no route found");
		} else {
			while (s != 0) {
				sb.append(name[s]).append(" ");
				s = bef[s];
			}
		}

		System.out.println(sb.toString());
	}
}