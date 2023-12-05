import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int[] parent;
	static int[] size;
	static boolean[] tree;
	static TreeSet<Integer> set;

	static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		set.remove(x);
		set.remove(y);

		if (x != y) {
			if (!tree[x] || !tree[y]) {
				tree[x] = false;
				tree[y] = false;
			} else if (x < y) {
				size[x] += size[y];
				parent[y] = x;
				set.add(x);
			} else {
				size[y] += size[x];
				parent[x] = y;
				set.add(y);
			}
		} else {
			tree[x] = false;
			tree[y] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		set = new TreeSet<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				if (size[b] != size[a])
					return size[b] - size[a];
				else {
					return a - b;
				}
			}

		});
		parent = new int[n + 1];
		size = new int[n + 1];
		tree = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			size[i] = 1;
			tree[i] = true;
			set.add(i);
		}

		int o, u, v;
		int x;
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			o = Integer.parseInt(st.nextToken());
			if (o == 1) {
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());

				union(u, v);
			} else {
				x = set.pollFirst();
				sb.append(x).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}