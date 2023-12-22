import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static class Node {
		int r;
		String x;

		public Node(int r, String x) {
			super();
			this.r = r;
			this.x = x;
		}

	}

	static LinkedList<Node> q;

	static boolean[] v;
	static int[] dr = new int[] { 0, 1 };

	static String bfs(int mod) {

		q.clear();
		q.add(new Node(1 % mod, "1"));

		v[1 % mod] = true;

		Node now;
		int nr;

		String answer = "BRAK";

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.r == 0) {
				answer = now.x;
				break;
			} else if (now.x.length() >= 100)
				break;

			for (int i = 0; i < 2; i++) {
				nr = (now.r * 10 + dr[i]) % mod;
				if (v[nr])
					continue;
				v[nr] = true;
				q.add(new Node(nr, now.x + dr[i]));
			}

		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		q = new LinkedList<>();

		int n;

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());
			v = new boolean[n];

			sb.append(bfs(n)).append("\n");

		}

		System.out.println(sb.toString());
	}
}