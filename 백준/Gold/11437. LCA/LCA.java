import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] connected;
	static int[] parent;
	static int[] depth;

	static void setAncestor(int x) {
		for (int y : connected[x]) {
			if (parent[y] != -1)
				continue;

			parent[y] = x;
			depth[y] = depth[x] + 1;

			setAncestor(y);
		}
	}

	static int findLCA(int x, int y) {// depth[x]<=depth[y]

		// depth 일치시키기
		while (depth[x] != depth[y]) {
			y = parent[y];
		}

		while (x != y) {
			x = parent[x];
			y = parent[y];
		}

		return x;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		connected = new ArrayList[n + 1];
		parent = new int[n + 1];
		depth = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			connected[i] = new ArrayList<>();
		}

		Arrays.fill(parent, -1);

		int a, b;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			connected[a].add(b);
			connected[b].add(a);
		}

		parent[1] = 0;

		setAncestor(1);

		int m = Integer.parseInt(br.readLine());

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			sb.append((depth[a] <= depth[b]) ? findLCA(a, b) : findLCA(b, a)).append("\n");
		}

		System.out.println(sb.toString());
	}
}