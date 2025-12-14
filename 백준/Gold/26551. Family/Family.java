import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static Map<String, Integer> indMap;
	static int ind = 0;

	static int getInd(String x) {
		if (!indMap.containsKey(x)) {
			indMap.put(x, ind++);
		}

		return indMap.get(x);
	}

	static int find(int x) {
		if (parent[x] != x)
			parent[x] = find(parent[x]);

		return parent[x];
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;
		else if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		indMap = new HashMap<>();

		int n = Integer.parseInt(br.readLine());

		int max = 2 * n;

		parent = new int[max];

		for (int i = 0; i < max; i++) {
			parent[i] = i;
		}

		String a, b;
		int aInd, bInd;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = st.nextToken();
			st.nextToken();
			b = st.nextToken();

			aInd = getInd(a);
			bInd = getInd(b);

			union(aInd, bInd);
		}

		int q = Integer.parseInt(br.readLine());

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = st.nextToken();
			b = st.nextToken();

			aInd = getInd(a);
			bInd = getInd(b);

			if (find(aInd) == find(bInd)) {
				sb.append("Related\n");
			} else {
				sb.append("Not Related\n");
			}
		}

		System.out.print(sb.toString());
	}
}