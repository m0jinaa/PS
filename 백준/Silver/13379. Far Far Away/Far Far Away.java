import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dist;
	static ArrayList<Node>[] canGo;
	static LinkedList<Node> q;

	static class Node {
		int x, d;

		public Node(int x, int d) {
			super();
			this.x = x;
			this.d = d;
		}
	}

	static int getMax() {
		dist = new int[n + 1];

		q.clear();

		q.add(new Node(1, 0));

		Node now;
		int nd;

		int max = 0;

		while (!q.isEmpty()) {
			now = q.poll();

			if (dist[now.x] > now.d)
				continue;

			for (Node next : canGo[now.x]) {
				nd = now.d + next.d;
				if (dist[next.x] >= nd)
					continue;
				q.add(new Node(next.x, nd));
				dist[next.x] = nd;
				max = Math.max(max, nd);
			}
		}

		return max >= m ? max : -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int a, b, c;

		q = new LinkedList<>();

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			canGo = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				canGo[i] = new ArrayList<>();
			}

			for (int i = 1; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());

				canGo[a].add(new Node(b, c));
			}

			sb.append(getMax()).append("\n");
		}

		System.out.println(sb.toString());
	}
}