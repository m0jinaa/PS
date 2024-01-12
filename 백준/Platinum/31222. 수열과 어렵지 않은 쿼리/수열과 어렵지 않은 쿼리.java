import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] A;
	static int[] tree;

	static void update(int x, int v) {
		while (x <= n) {
			tree[x] += v;
			x += (x & (-x));
		}
	}

	static int get(int x) {
		int s = 0;

		while (x > 0) {
			s += tree[x];
			x -= (x & (-x));
		}

		return s;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		tree = new int[n + 1];
		A = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if (A[i] != A[i - 1]) {
				update(i, 1);
			}
		}

		int o, x, v, l, r, sum;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());

			switch (o) {
			case 1:
				x = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				if (x > 1) {
					if (A[x] != A[x - 1] && A[x - 1] == v) {
						update(x, -1);
					} else if (A[x] == A[x - 1] && A[x - 1] != v) {
						update(x, 1);
					}
				}
				if (x < n) {
					if (A[x] != A[x + 1] && A[x + 1] == v) {
						update(x + 1, -1);
					} else if (A[x] == A[x + 1] && A[x + 1] != v) {
						update(x + 1, 1);
					}
				}
				A[x] = v;
				break;
			case 2:
				l = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());

				sum = get(r) - get(l) + 1;

				sb.append(sum).append("\n");
				break;
			}
		}

		System.out.print(sb.toString());
	}
}