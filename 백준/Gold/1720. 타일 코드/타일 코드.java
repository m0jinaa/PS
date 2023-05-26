import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] dp = new long[n+1];
		
		dp[0] = dp[1] = 1;
		long answer = 0;
		for(int i = 2;i<=n;i++) {
			dp[i] = dp[i-1]+2*dp[i-2];
		}
		
		if(n%2==0) {
			answer = (dp[n]+dp[n/2]+2*dp[n/2-1])/2;
		}
		else {
			answer = (dp[n]+dp[n/2])/2;
		}
		
		System.out.println(answer);
	}
}