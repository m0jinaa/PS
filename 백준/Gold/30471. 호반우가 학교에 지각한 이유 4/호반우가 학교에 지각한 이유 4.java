import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static long[] size;
	static long mini;

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
		mini -= (size[a] * (size[a] - 1)) / 2;
		mini -= (size[b] * (size[b] - 1)) / 2;
		if (a < b) {
			size[a] += size[b];
			parent[b] = a;
			mini += (size[a] * (size[a] - 1)) / 2;
		} else {
			size[b] += size[a];
			parent[a] = b;
			mini += (size[b] * (size[b] - 1)) / 2;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long king = n;

		parent = new int[n + 1];
		size = new long[n + 1];
        mini = 0;
        
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			union(a, b);

			sb.append(king + mini).append("\n");
		}

		System.out.println(sb.toString());
	}
}