import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		long[] sum = new long[n + 1];

		long[] D = new long[n + 1];

		int w, d;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			w = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			D[w] = d;
		}

		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + D[i];
		}

		int l = 0;
		int r = n;

		int p;
		long left, right;
		while (q-- > 0) {
			p = Integer.parseInt(br.readLine());

			if (p < l || r < p) {
				sb.append(0).append("\n");
			} else {
				// p에서 1번쪽으로 탈출하기위해 해야하는 망치질 횟수
				left = sum[p] - sum[l];

				// p에서 n번쪽으로 탈출하기위해 해야하는 망치질 횟수
				right = sum[r] - sum[p];

				// 비교 우선순위 : 망치질 횟수 -> 이동거리 비교
				if (left < right) {
					sb.append(left).append("\n");
					l = p;
				} else if (right < left) {
					sb.append(right).append("\n");
					r = p;
				} else if (2 * p <= n + 1) {
					sb.append(left).append("\n");
					l = p;
				} else {
					sb.append(right).append("\n");
					r = p;
				}
			}
		}
		System.out.println(sb.toString());
	}
}