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

		long[] sum = new long[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		int bef = 0;

		int x;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());
			if (i == 1) {
				sum[i] = 0;
			} else {
				sum[i] = sum[i - 1] + Math.abs(bef - x);
			}

			bef = x;
		}

		int s, e;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			sb.append(sum[e] - sum[s]).append("\n");
		}

		System.out.print(sb.toString());
	}
}