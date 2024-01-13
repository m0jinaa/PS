import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, h;
	static boolean[] v;
	static LinkedList<Node> q;

	static class Node {
		int x, c;

		public Node(int x, int c) {
			super();
			this.x = x;
			this.c = c;
		}
	}

	static int bfs() {
		Node now;
		int nx;

		int answer = 0;

		while (!q.isEmpty()) {
			now = q.poll();
			answer = Math.max(answer, now.c);

			for (int i = 0; i <= h; i++) {
				nx = now.x ^ (1 << i);

				if (nx > n || v[nx])
					continue;
				v[nx] = true;
				q.add(new Node(nx, now.c + 1));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		h = (int) Math.ceil(Math.log10(n) / Math.log10(2));

		v = new boolean[n + 1];

		q = new LinkedList<>();

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		int p;
		while (m-- > 0) {
			p = Integer.parseInt(st.nextToken());
			v[p] = true;
			q.add(new Node(p, 0));
		}

		System.out.println(bfs());
	}
}