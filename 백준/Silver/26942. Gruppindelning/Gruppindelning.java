import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
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

		if (x == y) {
			return false;
		} else if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		parent = new int[n];

		Map<String, Integer> indexMap = new HashMap<>();
		String name;

		for (int i = 0; i < n; i++) {
			name = br.readLine();

			indexMap.put(name, i);
			parent[i] = i;
		}

		String a, b;

		int m = Integer.parseInt(br.readLine());

		int aInd, bInd;

		int answer = n;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = st.nextToken();
			b = st.nextToken();

			aInd = indexMap.get(a);
			bInd = indexMap.get(b);

			if (union(aInd, bInd)) {
				answer--;
			}
		}

		System.out.println(answer);
	}
}