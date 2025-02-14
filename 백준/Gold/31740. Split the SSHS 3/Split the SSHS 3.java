import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int[] weight;
	static boolean[] v;
	static ArrayList<Integer>[] connectedTo;
	static int sum;
	static int min, a, b;

	static int getTreeWeight(int x) {
		int total = weight[x];
		int w;
		for (int y : connectedTo[x]) {
			if (v[y])
				continue;

			v[y] = true;

			w = getTreeWeight(y);

			total += w;

			if (min > Math.abs(sum - 2 * w)) {
				min = Math.abs(sum - 2 * w);
				a = x;
				b = y;
			}
		}

		return total;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		// initialize
		connectedTo = new ArrayList[n + 1];
		v = new boolean[n + 1];
		weight = new int[n + 1];
		sum = 0;
		min = INF;
		a = -1;
		b = -1;

		for (int i = 1; i <= n; i++) {
			connectedTo[i] = new ArrayList<>();
		}

		// add connections
		int x, y;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			connectedTo[x].add(y);
			connectedTo[y].add(x);
		}

		for (int i = 1; i <= n; i++) {
			weight[i] = Integer.parseInt(br.readLine());

			sum += weight[i];
		}

		getTreeWeight(1);

		sb.append(min).append("\n");
		sb.append(a).append(" ").append(b);

		System.out.println(sb.toString());
	}
}