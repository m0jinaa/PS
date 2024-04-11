import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] sum = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}

		int q = Integer.parseInt(br.readLine());

		int s, e;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken()) + 1;
			e = Integer.parseInt(st.nextToken()) + 1;

			sb.append(sum[e] - sum[s - 1]).append("\n");
		}

		System.out.print(sb.toString());
	}
}