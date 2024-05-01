import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int ind = 0;

	static HashMap<String, Integer> map;
	static int[] parent;

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;

		if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
		return true;
	}

	public static int getInd(String name) {
		map.putIfAbsent(name, ind);

		int ret = map.get(name);

		if (ret == ind) {
			ind++;
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n;
		int a, b;

		int tc = 1;
		int cnt;

		map = new HashMap<>();

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			parent = new int[n];

			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}

			map.clear();
			ind = 0;

			cnt = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				a = getInd(st.nextToken());
				b = getInd(st.nextToken());

				if (!union(a, b))
					cnt++;
			}

			sb.append(tc).append(" ").append(cnt).append("\n");

			tc++;
		}

		System.out.print(sb.toString());
	}
}