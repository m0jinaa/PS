import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static long[] size;
	static int cnt;
	static long total;

	static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b) {
			return;
		}
		total -= size[b] * size[b];
		total -= size[a] * size[a];
		if (a < b) {
			size[a] += size[b];
			total += size[a] * size[a];
			parent[b] = a;

		} else {
			size[b] += size[a];
			total += size[b] * size[b];
			parent[a] = b;
		}

		cnt--;
	}

	static long gcd(long a, long b) {
		long t;
		if (a < b) {
			t = a;
			a = b;
			b = t;
		}

		while (b != 0) {
			t = a % b;
			a = b;
			b = t;
		}

		return a + b;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		cnt = n;
		total = n;
		parent = new int[n + 1];
		size = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		int o, u, v;

		long g;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());

			switch (o) {
			case 1:
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());

				union(u, v);
				break;
			case 2:
				g = gcd(total, cnt);
				sb.append(total / g).append("/").append(cnt / g).append("\n");
				break;
			}
		}

		System.out.println(sb.toString());
	}
}