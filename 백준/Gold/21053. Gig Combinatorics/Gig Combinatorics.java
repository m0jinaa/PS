import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
    	
        int MOD = 1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n];
		int[] dp = new int[4];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			switch (nums[i]) {
			case 1:
				dp[1] = (dp[1] + 1) % MOD;
				break;
			case 2:
				dp[2] = (2 * dp[2] + dp[1]) % MOD;
				break;
			case 3:
				dp[3] = (dp[3] + dp[2]) % MOD;
				break;
			}
		}
        
		System.out.println(dp[3]);
	}
}