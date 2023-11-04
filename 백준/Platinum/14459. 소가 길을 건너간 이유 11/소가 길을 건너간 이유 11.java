import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int n;
	static int[] list;

	static class Node implements Comparable<Node> {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node node) {
			if (this.x != node.x)
				return this.x - node.x;
			else {
				return node.y - this.y;
			}
		}
	}

	static int getFirstLarge(int s, int e, int v) {
		if (s == e)
			return s;
		int m = (s + e) / 2;

		if (v < list[m]) {
			return getFirstLarge(s, m, v);
		} else if (v == list[m])
			return m;
		else {
			return getFirstLarge(m + 1, e, v);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		int[] A = new int[n + 1];
		int[] B = new int[n + 1];

		int x;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(br.readLine());
			A[i] = x;
		}

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(br.readLine());
			B[x] = i;
		}

		ArrayList<Node> q = new ArrayList<>();

		int l, r;

		for (int i = 1; i <= n; i++) {
			l = Math.max(1, A[i] - 4);
			r = Math.min(n, A[i] + 4);
			for (int j = l; j <= r; j++) {
				q.add(new Node(i, B[j]));
			}
		}

		Collections.sort(q);

		list = new int[n + 1];

		int ind = 1;

		for (Node node : q) {
			if (node.y > list[ind - 1]) {
				list[ind++] = node.y;
			} else {
				list[getFirstLarge(1, ind - 1, node.y)] = node.y;
			}
		}

		System.out.println(ind - 1);
	}
}