import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int[] dp = new int[x + 1];

		dp[0] = 1;

		int l, c, s;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			l = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			for (int i = x; i > 0; i--) {
				s = 0;
				for (int j = 0; j < c; j++) {
					s += l;
					if (i < s)
						break;
					dp[i] += dp[i - s];
				}
			}
		}

		System.out.println(dp[x]);
	}
}