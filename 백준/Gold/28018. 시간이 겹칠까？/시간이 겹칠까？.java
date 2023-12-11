import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int MAX = 1000002;
		int[] student = new int[MAX];
		int[] dp = new int[MAX];

		int n = Integer.parseInt(br.readLine());

		int s, e;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			student[s]++;
			student[e + 1]--;
		}

		for (int i = 1; i < MAX; i++) {
			dp[i] = dp[i - 1] + student[i];
		}

		int q = Integer.parseInt(br.readLine());

		int x;

		st = new StringTokenizer(br.readLine(), " ");

		while (q-- > 0) {
			x = Integer.parseInt(st.nextToken());

			sb.append(dp[x]).append("\n");
		}

		System.out.print(sb.toString());
	}
}