import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] weight;

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int a, int b, int w) {
		a = find(a);
		b = find(b);

		if (a == b)
			return;
		else if (a < b) {
			parent[b] = a;
			weight[a] = w;
		} else {
			parent[a] = b;
			weight[b] = w;
		}
	}

	static class Street implements Comparable<Street> {
		int a, b, w;

		public Street(int a, int b, int w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Street s) {
			return s.w - this.w;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int n, m;
		int a, b, w, answer;
		Street[] streets;

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			parent = new int[n + 1];
			weight = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}

			streets = new Street[m];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				streets[i] = new Street(a, b, w);
			}

			Arrays.sort(streets);

			answer = -1;

			for (Street s : streets) {
				if (find(n) == 1) {
					break;
				}
				union(s.a, s.b, s.w);
			}
			answer = weight[1];

			sb.append("Scenario #").append(t).append(":\n").append(answer).append("\n\n");
		}

		System.out.println(sb.toString());
	}
}