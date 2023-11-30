import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] parent;

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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		int x;
		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(br.readLine());
			union(i, x);
		}

		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			if (find(i) == i) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}
}