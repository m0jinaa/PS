import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static boolean[] v;
	static int n, a, b;
	static int MOD;

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
		else if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
		return true;
	}

	static int bfs(int start) {

		int e = start;
		int x, y;

		int cnt = 0;
		int answer = 0;
		int day = 0;

		while (!v[e]) {
			v[e] = true;
			day++;
			x = e / n;
			y = e % n;
			if (union(x, y)) {
				cnt++;
			}

			if (cnt == n - 1) {
				answer = day;
				break;
			}
			e = (int) ((1L * e * a + b) % MOD);
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		int seed, e;
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			MOD = n * n;
			seed = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken()) % MOD;
			b = Integer.parseInt(st.nextToken()) % MOD;

			parent = new int[n];

			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
			v = new boolean[MOD];

			e = seed % MOD;

			sb.append(bfs(e)).append("\n");
		}

		System.out.print(sb.toString());
	}
}