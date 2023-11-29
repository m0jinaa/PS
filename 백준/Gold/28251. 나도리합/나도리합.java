import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static long[] power;
	static long[] sum;

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static long union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return sum[x];
		} else if (x < y) {
			sum[x] += sum[y] + power[x] * power[y];
			power[x] += power[y];
			parent[y] = x;
			return sum[x];
		} else {
			sum[y] += sum[x] + power[x] * power[y];
			power[y] += power[x];
			parent[x] = y;
			return sum[y];
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		sum = new long[n + 1];
		power = new long[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			power[i] = Long.parseLong(st.nextToken());
		}

		int a, b;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			sb.append(union(a, b)).append("\n");
		}

		System.out.println(sb.toString());
	}
}