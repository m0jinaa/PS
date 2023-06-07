import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long[] subject = new long[n];
		long x;
		int k, t;
		for (int i = 0; i < n; i++) {
			x = 0L;
			st = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			while (k-- > 0) {
				t = Integer.parseInt(st.nextToken());
				x += 1L << t;
			}
			subject[i] = x;
		}

		int m = Integer.parseInt(br.readLine());

		int p, q, cnt;
		for (int i = 0; i < m; i++) {
			x = 0L;
			st = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			while (p-- > 0) {
				q = Integer.parseInt(st.nextToken());
				x += 1L << q;
			}

			cnt = 0;

			for (long y : subject) {
				if ((x & y) == y) {
					cnt++;
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());

	}
}
