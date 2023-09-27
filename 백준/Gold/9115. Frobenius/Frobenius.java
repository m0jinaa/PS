import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] dp;
	static int[] nums;
	static int n = 4;
	static int MAX = 2_000_001;

	static void check() {

		for (int i : nums) {
			for (int j = i; j < MAX; j++) {
				dp[j] = dp[j] || dp[j - i];
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		nums = new int[4];
		dp = new boolean[MAX];
		int tc = Integer.parseInt(br.readLine());
		int c, m;
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < 4; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.fill(dp, false);
			dp[0] = true;

			check();
			c = 0;
			m = -1;
			for (int i = MAX - 1; i >= 0; i--) {
				if (dp[i])
					continue;
				if(i<=1_000_000)
					c++;
				m = Math.max(i, m);
			}

			sb.append(c).append("\n").append(m>1_000_000?-1:m).append("\n");

		}

		System.out.println(sb.toString());
	}
}