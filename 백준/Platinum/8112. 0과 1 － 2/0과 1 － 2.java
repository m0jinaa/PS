import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static boolean[] v;

	static class Node {
		int x;
		String n;

		public Node(int x, String n) {
			super();
			this.x = x;
			this.n = n;
		}
	}

	static LinkedList<Node> q;

	static String bfs(int MOD) {
		q.clear();

		q.add(new Node(1%MOD, "1"));
		v[1%MOD] = true;

		Node now;
		String answer = "BRAK";
		int nx;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == 0) {
				answer = now.n;
				break;
			}

			for (int i = 0; i < 2; i++) {
				nx = (now.x * 10 + i) % MOD;
				if (v[nx])
					continue;
				v[nx] = true;
				q.add(new Node(nx, now.n + i));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		q = new LinkedList<>();

		int n = Integer.parseInt(br.readLine());
		int x;
		while (n-- > 0) {
			x = Integer.parseInt(br.readLine());
			v = new boolean[x];
			sb.append(bfs(x)).append("\n");
		}

		System.out.println(sb.toString());
	}
}