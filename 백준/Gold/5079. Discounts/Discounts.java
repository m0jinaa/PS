import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String store;
		int pd, pc;
		int d, b, f;

		final int MAX = 500;

		int[] dp = new int[MAX + 1];

		int e, v;
		int dollar, cent;

		while ((store = br.readLine()) != null && !"#".equals(store)) {
			if (sb.length() != 0) {
				sb.append("\n");
			}

			st = new StringTokenizer(br.readLine(), " ");

			Arrays.fill(dp, 0);

			pd = Integer.parseInt(st.nextToken());
			pc = Integer.parseInt(st.nextToken());

			d = Integer.parseInt(br.readLine());

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				b = Integer.parseInt(st.nextToken());
				f = Integer.parseInt(st.nextToken());

				for (int x = b; x <= MAX; x++) {
					for (int y = 0; y <= f && x + y <= MAX; y++) {
						dp[x + y] = Math.max(dp[x + y], dp[x - b] + y);
					}
				}
			}

			e = Integer.parseInt(br.readLine());

			sb.append(store).append("\n");

			while (e-- > 0) {
				v = Integer.parseInt(br.readLine());

				dollar = pd * dp[v];
				cent = pc * dp[v];

				dollar += (cent / 100);
				cent %= 100;

				sb.append("Buy ").append(v).append(", save $").append(dollar).append(".")
						.append(String.format("%02d", cent)).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}