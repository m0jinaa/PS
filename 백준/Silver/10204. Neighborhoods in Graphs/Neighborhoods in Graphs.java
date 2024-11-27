import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] v;
	static ArrayList<Integer>[] connectedTo;
	static LinkedList<Integer> q;

	static int bfs(int x) {
		int cnt = 0;

		q.clear();
		q.add(x);
		v[x] = 0;

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			if (v[now] < 2) {
				for (int nx : connectedTo[now]) {
					if (v[nx] != -1)
						continue;
					v[nx] = v[now] + 1;
					cnt++;
					q.add(nx);
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int m, a, b, x;

		q = new LinkedList<>();

		int tc = Integer.parseInt(br.readLine().trim());

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " v");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			v = new int[n + 1];

			Arrays.fill(v, -1);

			connectedTo = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				connectedTo[i] = new ArrayList<>();
			}

			while (m-- > 0) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				connectedTo[a].add(b);
				connectedTo[b].add(a);
			}

			x = Integer.parseInt(st.nextToken());

			sb.append("The number of supervillains in 2-hop neighborhood of v").append(x).append(" is ").append(bfs(x))
					.append("\n");
		}

		System.out.println(sb.toString());
	}
}