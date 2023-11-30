import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static int[] parent;
	static HashMap<Integer, Integer> map;
	static int ind;

	static class Query implements Comparable<Query> {
		int i, j, e;

		public Query(int i, int j, int e) {
			super();
			this.i = i;
			this.j = j;
			this.e = e;
		}

		@Override
		public int compareTo(Query q) {
			return q.e - this.e;
		}
	}

	static int getInd(int x) {
		map.putIfAbsent(x, ind++);
		return map.get(x);
	}

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return;
		else if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int t = sc.nextInt();

		boolean satisfied;

		int n;
		Query[] queries;
		int a, b, e;
		map = new HashMap<>();

		while (t-- > 0) {
			satisfied = true;
			n = sc.nextInt();
			ind = 1;
			map.clear();

			queries = new Query[n];

			for (int i = 0; i < n; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				e = sc.nextInt();

				queries[i] = new Query(getInd(a), getInd(b), e);
			}

			Arrays.sort(queries);

			parent = new int[ind];

			for (int i = 1; i < ind; i++) {
				parent[i] = i;
			}

			for (Query q : queries) {
				if (q.e == 1) {
					union(q.i, q.j);
				} else {
					if (find(q.i) == find(q.j)) {
						satisfied = false;
						break;
					}
				}
			}

			sb.append(satisfied ? "YES\n" : "NO\n");
		}

		System.out.print(sb.toString());
	}
}