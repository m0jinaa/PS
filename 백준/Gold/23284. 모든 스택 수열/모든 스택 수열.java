import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static StringBuilder sb;
	static int[] A;
	static boolean[] v;

	static void makeArray(int p, int x) {
		if (p > n) {
			for (int i = 1; i <= n; i++) {
				sb.append(A[i]).append(i == n ? "\n" : " ");
			}
		} else {
			for (int i = 1; i <= n; i++) {
				if (v[i])
					continue;
				if (A[p - 1] < i && i < x)
					break;

				A[p] = i;
				v[i] = true;
				if (i >= x) {
					makeArray(p + 1, i + 1);
				} else {
					makeArray(p + 1, x);
				}
				v[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		A = new int[n + 1];
		v = new boolean[n + 1];

		makeArray(1, 0);

		System.out.println(sb.toString());
	}
}