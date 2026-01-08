import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x, d;

		public Node(int x, int d) {
			super();
			this.x = x;
			this.d = d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Node[] parent = new Node[n];

		int answer = 0;

		int s, t, d;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			parent[t] = new Node(s, d);
		}

		LinkedList<Integer> q = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");
		int a;
		boolean[] v = new boolean[n];

		while (k-- > 0) {
			a = Integer.parseInt(st.nextToken());
			q.add(a);
		}

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			if (v[now])
				continue;

			v[now] = true;

			if (now == 0)
				continue;

			answer += (2 * parent[now].d);

			q.add(parent[now].x);
		}

		System.out.println(answer);
	}
}