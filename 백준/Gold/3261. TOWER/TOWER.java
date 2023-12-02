import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] size, parent;

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b) {
			return;
		} else if (a < b) {
			size[a] += size[b];
			parent[b] = a;
		} else {
			size[b] += size[a];
			parent[a] = b;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		size = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		int first = 0;
		int second = 0;

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			union(a, b);
		}

		for (int i = 1; i <= n; i++) {
			if (find(i) == i) {
				if (size[first] < size[i]) {
					second = first;
					first = i;
				} else if (size[second] < size[i]) {
					second = i;
				}
			}
		}

		if (second == 0) {
			second = 1;
		}

		System.out.println(first + " " + second);

	}
}