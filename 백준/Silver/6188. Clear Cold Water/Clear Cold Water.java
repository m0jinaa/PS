import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] connectedTo;
	static int[] v;

	static void bfs() {
		LinkedList<Integer> q = new LinkedList<>();

		v[0] = -1;

		q.add(1);
		v[1] = 1;

		int x;

		while (!q.isEmpty()) {
			x = q.poll();

			for (int nx : connectedTo[x]) {
				if (v[nx] != 0)
					continue;
				v[nx] = v[x] + 1;
				q.add(nx);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		v = new int[n + 1];
		connectedTo = new int[n + 1][2];

		int e, b1, b2;

		while (c-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			e = Integer.parseInt(st.nextToken());
			b1 = Integer.parseInt(st.nextToken());
			b2 = Integer.parseInt(st.nextToken());

			connectedTo[e][0] = b1;
			connectedTo[e][1] = b2;
		}

		bfs();

		for (int i = 1; i <= n; i++) {
			sb.append(v[i]).append("\n");
		}

		System.out.println(sb.toString());
	}
}