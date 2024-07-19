import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int c = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[] dp = new int[c + 1];

		int v;

		while (h-- > 0) {
			v = Integer.parseInt(br.readLine());

			for (int i = c; i >= v; i--) {
				dp[i] = Math.max(dp[i], dp[i - v] + v);
			}
		}

		System.out.println(dp[c]);
	}
}