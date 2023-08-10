import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static final String MOD = "1000000007";

	static Node[] a;
	static ArrayList<Integer>[] canGo;
	static boolean[] v;

	static class Node {
		int ind;
		String x;

		public Node(int ind, String x) {
			super();
			this.ind = ind;
			this.x = x;
		}

	}

	static void dfs(int s, int e, String now) {
		v[s] = true;
		if (s == e) {
			sb.append((new BigInteger(now)).remainder(new BigInteger(MOD))).append("\n");
		} else {
			for (int y : canGo[s]) {
				if (v[y])
					continue;
				dfs(y, e, now + a[y].x);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		a = new Node[n + 1];
		v = new boolean[n + 1];
		canGo = new ArrayList[n + 1];

		st = new StringTokenizer(br.readLine());

		String x;

		for (int i = 1; i <= n; i++) {
			x = st.nextToken();
			a[i] = new Node(i, x);
			canGo[i] = new ArrayList<>();

		}

		int s, e;
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			canGo[s].add(e);
			canGo[e].add(s);

		}
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(v, false);
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			dfs(s, e, a[s].x);

		}

		System.out.println(sb.toString());
	}
}