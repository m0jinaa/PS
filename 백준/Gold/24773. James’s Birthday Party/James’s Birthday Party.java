import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] parent;
	static int[] cnt;

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;
		else if (x < y) {
			cnt[x] += cnt[y];
			cnt[y] = 0;
			parent[y] = x;
		} else {
			cnt[y] += cnt[x];
			cnt[x] = 0;
			parent[x] = y;
		}
	}

	public static void init() {
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			cnt[i] = 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[][] edges;

		int m, a, b;
		boolean possible;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			parent = new int[n];
			cnt = new int[n];

			edges = new int[m][2];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				edges[i][0] = a;
				edges[i][1] = b;
			}

			possible = true;

			for (int i = 0; i < m; i++) {
				init();
				for (int j = 0; j < m; j++) {
					if (i == j)
						continue;
					union(edges[j][0], edges[j][1]);
				}

				if (cnt[0] != n) {
					possible = false;
					break;
				}
			}

			sb.append(possible ? "No\n" : "Yes\n");
		}

		System.out.println(sb.toString());
	}
}