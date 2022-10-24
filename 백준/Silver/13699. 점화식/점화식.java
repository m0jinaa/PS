import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n+1];
		dp[0] = 1;
		for(int i = 1;i<=n;i++) {
			for(int j = 0,k=i-1;j<=i/2;j++,k--) {
				if(j<k)
					dp[i]+=2*dp[j]*dp[k];
				else if(j==k)
					dp[i]+=dp[j]*dp[k];
				else
					break;
			}
		}
		System.out.println(dp[n]);
	}
}