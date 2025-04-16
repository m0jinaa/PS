import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] A, B;
	static int[] sumTree;

	static void update(int s, int e, int ind, int v, int x) {
		if (ind < s || e < ind)
			return;
		else {
			sumTree[x] += v;

			if (s != e) {
				int m = (s + e) / 2;

				update(s, m, ind, v, 2 * x);
				update(m + 1, e, ind, v, 2 * x + 1);
			}
		}
	}

	static int get(int s, int e, int v, int x) {
		if (sumTree[x] < v)
			return -1;
		else if (s == e)
			return s;
		else {
			int m = (s + e) / 2;

			if (sumTree[2 * x + 1] >= v) {
				return get(m + 1, e, v, 2 * x + 1);
			} else {
				return get(s, m, v - sumTree[2 * x + 1], 2 * x);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		A = new int[n + 1];
		B = new int[n + 1];

		int N = (int) Math.pow(2, Math.ceil(Math.log10(n) / Math.log10(2)) + 1);

		sumTree = new int[N];

		for (int i = 1; i <= n; i++) {
			B[i] = Integer.parseInt(br.readLine()) + 1;
			update(1, n, i, 1, 1);
		}

		boolean possible = true;

		for (int i = n; i > 0; i--) {
			A[i] = get(1, n, B[i], 1);

			if (A[i] == -1) {
				possible = false;
				break;
			}
			update(1, n, A[i], -1, 1);
		}

		if (possible) {
			for (int i = 1; i <= n; i++) {
				sb.append(A[i]).append("\n");
			}
		} else {
			sb.append("NIE\n");
		}

		System.out.print(sb.toString());
	}
}