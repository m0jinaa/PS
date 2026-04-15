import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] size;
	static int[] parent;

	static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	static int union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return 0;
		else if (x < y) {
			size[x] += size[y];
			size[y] = 0;
			parent[y] = x;

			return size[x];
		} else {
			size[y] += size[x];
			size[x] = 0;
			parent[x] = y;

			return size[y];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		size = new int[n + 1];
		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			size[i] = 1;
			parent[i] = i;
		}

		int x, y;

		int answer = 1;

		int s;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			s = union(x, y);
			answer = Math.max(answer, s);
		}

		System.out.println(answer);
	}
}