import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static LinkedList<Integer> q;

	static boolean[] bfs(int x, ArrayList<Integer>[] canGo) {
		boolean[] v = new boolean[n + 1];
		q.clear();
		q.add(x);
		v[x] = true;
		int now;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int y : canGo[now]) {
				if (v[y])
					continue;
				v[y] = true;
				q.add(y);
			}
		}
		return v;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] original = new ArrayList[n + 1];
		ArrayList<Integer>[] reverse = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			original[i] = new ArrayList<>();
			reverse[i] = new ArrayList<>();
		}
		int x, y;

		q = new LinkedList<>();

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			original[x].add(y);
			reverse[y].add(x);
		}

		boolean[] fromOne = bfs(1, original);
		boolean[] fromLast = bfs(n, reverse);

		int t = Integer.parseInt(br.readLine());

		int c;

		while (t-- > 0) {
			c = Integer.parseInt(br.readLine());
			sb.append(fromOne[c] && fromLast[c] ? "Defend the CTP\n" : "Destroyed the CTP\n");
		}

		System.out.print(sb.toString());
	}
}