import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] cnt;
	static int l, r, total, half;
	static boolean[] dp;

	static void check() {
		dp[0] = true;

		for (int i = l; i <= r; i++) {
			if (cnt[i] == 0)
				continue;
			for (int j = 0; j < cnt[i]; j++) {
				for (int k = half; k >= i; k--) {
					dp[k] |= dp[k - i];
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		l = 1;
		r = 6;

		cnt = new int[r + 1];
		int t = 0;
		while (true) {

			st = new StringTokenizer(br.readLine(), " ");
			total = 0;
			for (int i = l; i <= r; i++) {
				cnt[i] = Integer.parseInt(st.nextToken());
				total += i * cnt[i];
			}

			if (total == 0)
				break;
			t++;
			if (t != 1) {
				sb.append("\n");
			}
			sb.append("Collection #").append(t).append(":\n");

			if (total % 2 == 0) {
				half = total / 2;

				dp = new boolean[half + 1];

				check();

				if (dp[half]) {
					sb.append("Can be divided.\n");
				} else {
					sb.append("Can't be divided.\n");
				}
			} else {
				sb.append("Can't be divided.\n");
			}
		}

		System.out.println(sb.toString());
	}
}