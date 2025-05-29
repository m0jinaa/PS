import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 1_000_000;
	static int n;
	static int[] height;
	static LinkedList<Integer>[] connectedTo;

	static boolean canReach(int v, int bef, int h) {
		for (int w : connectedTo[v]) {
			if (bef == w)
				continue;
			else if (height[w] >= h)
				return true;
			else if (h * 2 - height[w] <= MAX && canReach(w, v, h * 2 - height[w]))
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		height = new int[n + 1];
		connectedTo = new LinkedList[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			connectedTo[i] = new LinkedList<>();
		}

		int u, v;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			connectedTo[u].add(v);
			connectedTo[v].add(u);
		}

		System.out.println(canReach(k, -1, height[k]) ? 1 : 0);
	}
}