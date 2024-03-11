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
		int q = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		long[] sum = new long[2 * n + 1];

		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int i = n + 1; i <= 2 * n; i++) {
			sum[i] = sum[n] + sum[i - n];
		}
		int d = 0;
		int s, e;

		int o;
		int a, b, k;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());

			switch (o) {
			case 1:
				k = Integer.parseInt(st.nextToken());
				d = d + n - k;
				while (d > n) {
					d -= n;
				}
				break;
			case 2:
				k = Integer.parseInt(st.nextToken());
				d = d + k;
				while (d > n) {
					d -= n;
				}
				break;
			case 3:
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				s = a + d;
				e = b + d;

				sb.append(sum[e] - sum[s - 1]).append("\n");
				break;
			}
		}

		System.out.println(sb.toString());
	}
}