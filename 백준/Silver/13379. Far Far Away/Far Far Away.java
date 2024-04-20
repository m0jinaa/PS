import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int threshold;
	static boolean[] v;
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

	static int bfs() {
		q.clear();

		q.add(new Node(1, 0));
		v[1] = true;

		Node now;
		int nd;
		int answer = 0;

		while (!q.isEmpty()) {
			now = q.poll();

			for (Node next : canGo[now.x]) {
				if (v[next.x])
					continue;
				v[next.x] = true;
				nd = now.d + next.d;
				q.add(new Node(next.x, nd));
				answer = Math.max(answer, nd);
			}
		}

		return answer >= threshold ? answer : -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n;
		int a, b, c;

		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			threshold = Integer.parseInt(st.nextToken());

			canGo = new ArrayList[n + 1];
			v = new boolean[n + 1];
			q = new LinkedList<>();

			for (int i = 1; i <= n; i++) {
				canGo[i] = new ArrayList<>();
			}

			for (int i = 1; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());

				canGo[a].add(new Node(b, c));
				canGo[b].add(new Node(a, c));
			}

			sb.append(bfs()).append("\n");
		}

		System.out.println(sb.toString());
	}
}