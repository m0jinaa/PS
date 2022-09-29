import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static int[] dp;
	
	static int makeOne(int k) {
		if(dp[k]!=-1)
			return dp[k];
		if(k%6==0) {
			dp[k] = Math.min(makeOne(k/3), makeOne(k/2))+1;
		}
		else if(k%3==0) {
			dp[k] = Math.min(makeOne(k/3), makeOne(k-1))+1;
		}
		else if(k%2==0) {
			dp[k] = Math.min(makeOne(k/2), makeOne(k-1))+1;
		}
		else
			dp[k] = makeOne(k-1)+1;
		return dp[k];
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		Arrays.fill(dp,-1);
		dp[1] = 0;
		
		System.out.println(makeOne(n));
	}
}
