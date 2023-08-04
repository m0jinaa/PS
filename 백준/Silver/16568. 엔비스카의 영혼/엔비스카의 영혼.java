import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dx;
	static boolean[] v;

	static class Node {
		int x, c;

		public Node(int x, int c) {
			super();
			this.x = x;
			this.c = c;
		}

	}

	static int bfs() {
		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(0, 0));
		v[0] = true;
		int answer = n;
		Node now;
		int nx;
		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == n) {
				answer = now.c;
				break;
			}

			for (int i = 0; i < 3; i++) {
				nx = now.x + dx[i];
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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		dx = new int[3];
		v = new boolean[n + 1];

		dx[0] = 1;
		dx[1] = Integer.parseInt(st.nextToken()) + 1;
		dx[2] = Integer.parseInt(st.nextToken()) + 1;

		System.out.println(bfs());
	}
}