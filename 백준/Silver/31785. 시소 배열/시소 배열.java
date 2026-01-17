import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 500_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long[] A = new long[MAX + 1];

		int s = 1;
		int e = 0;
		int m;

		int q = Integer.parseInt(br.readLine());

		int o, x;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			o = Integer.parseInt(st.nextToken());

			if (o == 1) {
				x = Integer.parseInt(st.nextToken());
				A[e + 1] = A[e] + x;
				e++;
			} else {
				m = (s + e - 1) / 2;
				if (A[m] - A[s - 1] <= A[e] - A[m]) {
					sb.append(A[m] - A[s - 1]).append("\n");
					s = m + 1;
				} else {
					sb.append(A[e] - A[m]).append("\n");
					e = m;
				}
			}
		}

		for (int i = s; i <= e; i++) {
			sb.append(A[i] - A[i - 1]).append(" ");
		}

		System.out.println(sb.toString());
	}
}