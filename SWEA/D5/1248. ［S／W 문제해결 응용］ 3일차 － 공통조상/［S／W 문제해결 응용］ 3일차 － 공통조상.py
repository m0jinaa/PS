import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<Integer>[] children;
	static int[] depth, parent, size;
	static StringBuilder sb = new StringBuilder();

	static void init(int s) {
		depth = new int[s + 1];
		parent = new int[s + 1];
		size = new int[s + 1];

		children = new ArrayList[s + 1];

		for (int i = 1; i <= s; i++) {
			children[i] = new ArrayList<Integer>();
		}
	}

	static int setDepth(int now, int d) {
		depth[now] = d;
		size[now] = 1;

		for (int next : children[now]) {
			size[now] += setDepth(next, d + 1);
		}

		return size[now];
	}

	static void getClosestAncestor(int p, int q) {

		while (p != q) {
			if (depth[p] > depth[q]) {
				p = parent[p];
			} else if (depth[q] > depth[p]) {
				q = parent[q];
			} else {
				p = parent[p];
				q = parent[q];
			}
		}

		sb.append(p).append(" ").append(size[p]);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int v, e, x, y, a, b;
		for (int t = 1; t <= tc; t++) {

			st = new StringTokenizer(br.readLine(), " ");

			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			init(v);

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < e; i++) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				parent[b] = a;
				children[a].add(b);
			}

			setDepth(1, 0);

			sb.append("#").append(t).append(" ");
			getClosestAncestor(x, y);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

}
