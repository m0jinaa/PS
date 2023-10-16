import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;
	static int n;

	static void update(int x) {
		while (x <= n) {
			tree[x]++;
			x += (x & (-x));
		}
	}

	static int get(int x) {
		int ret = 0;

		while (x > 0) {
			ret += tree[x];
			x -= (x & (-x));
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		long l = Long.parseLong(st.nextToken());

		int x;

		tree = new int[n + 1];

		long cnt = 0;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());

			cnt += (i - 1) - get(x);

			update(x);
		}

		long answer = Math.min(l + cnt, 1L * n * (n - 1) / 2);

		System.out.println(answer);
	}
}